package serverconfig;

import java.io.IOException;
import java.util.NoSuchElementException;

import config.Config;
import utils.Attachment;
import utils.Binding;
import utils.Port;
import utils.Type;

public class ServerConfig {

	private static ServerConfig INSTANCE;

	private ConnectionManager connectionManager;
	private Attachment attachmentptor_cmtosm;
	private Attachment attachmentrtop_smtocm;
	private Attachment attachmentptor_cmtod;
	private Attachment attachmentrtop_dtocm;

	private Database database;
	private Attachment attachmentrtop_cmtod;
	private Attachment attachmentptor_dtocm;
	private Attachment attachmentptor_dtosm;
	private Attachment attachmentrtop_smtod;

	private SecurityManager securityManager;
	private Attachment attachmentrtop_cmtosm;
	private Attachment attachmentptor_smtocm;
	private Attachment attachmentrtop_dtosm;
	private Attachment attachmentptor_smtod;

	private ConnectorCMD connectorCMD;
	private ConnectorCMSM connectorCMSM;
	private ConnectorSMD connectorSMD;

	private Binding bindingCMtoConfig;
	private Binding bindingConfigtoCM;
	private Port portserverconfig_p;
	private Port portserverconfig_r;

	private ServerConfig() {
		connectionManager = new ConnectionManager();
		database = new Database();
		securityManager = new SecurityManager();

		connectorCMD = new ConnectorCMD();
		connectorCMSM = new ConnectorCMSM();
		connectorSMD = new ConnectorSMD();

		// ConnectionManager required and provided attachments
		attachmentptor_cmtosm = new Attachment(connectionManager.getPortcmtosm_p(),
				connectorCMSM.getGluecmtosm().getRequired());
		attachmentrtop_smtocm = new Attachment(connectionManager.getPortsmtocm_r(),
				connectorCMSM.getGluesmtocm().getProvided());
		attachmentptor_cmtod = new Attachment(connectionManager.getPortcmtod_p(),
				connectorCMD.getGluecmtod().getRequired());
		attachmentrtop_dtocm = new Attachment(connectionManager.getPortdtocm_r(),
				connectorCMD.getGluedtocm().getProvided());

		// Database required and provided attachments
		attachmentrtop_cmtod = new Attachment(database.getPortcmtod_r(), connectorCMD.getGluecmtod().getProvided());
		attachmentptor_dtocm = new Attachment(database.getPortdtocm_p(), connectorCMD.getGluedtocm().getRequired());
		attachmentptor_dtosm = new Attachment(database.getPortdtosm_p(), connectorSMD.getGluedtosm().getRequired());
		attachmentrtop_smtod = new Attachment(database.getPortsmtod_r(), connectorSMD.getGluesmtod().getProvided());

		// SecurityManager required and provided attachments
		attachmentrtop_cmtosm = new Attachment(securityManager.getPortcmtosm_r(),
				connectorCMSM.getGluecmtosm().getProvided());
		attachmentptor_smtocm = new Attachment(securityManager.getPortsmtocm_p(),
				connectorCMSM.getGluesmtocm().getRequired());
		attachmentrtop_dtosm = new Attachment(securityManager.getPortdtosm_r(),
				connectorSMD.getGluedtosm().getProvided());
		attachmentptor_smtod = new Attachment(securityManager.getPortsmtod_p(),
				connectorSMD.getGluesmtod().getRequired());

		// Create binding and ports
		portserverconfig_p = new Port("portserverconfig_p", Type.PROVIDED, null);
		portserverconfig_r = new Port("portserverconfig_r", Type.REQUIRED, null);
		bindingCMtoConfig = new Binding(connectionManager.getPortcmserverconfig_p(), portserverconfig_p);
		bindingConfigtoCM = new Binding(connectionManager.getPortcmserverconfig_r(), portserverconfig_r);
	}

	public static ServerConfig getInstance() throws NoSuchElementException, IllegalArgumentException, IOException {
		if (INSTANCE == null) {
			synchronized (Config.class) {
				if (INSTANCE == null) {
					INSTANCE = new ServerConfig();
				}
			}
		}

		return INSTANCE;
	}

	public void transmitCMtoD() {
		// Put the message in the connector role required
		attachmentptor_cmtod.getRole().setMsg(attachmentptor_cmtod.getPort().getMsg());

		// The message is processed by the connector
		connectorCMD.processingCMtoD();

		// Put the message in database port required
		database.getPortcmtod_r().setMsg(attachmentrtop_cmtod.getRole().getMsg());

		// Call database receive function
		database.receiveConnectionManager();
	}

	public void transmitDtoCM() {
		// Put the message in the connector role required
		attachmentptor_dtocm.getRole().setMsg(attachmentptor_dtocm.getPort().getMsg());

		// The message is processed by the connector
		connectorCMD.processingDtoCM();

		// Put the message in connection manager port required
		connectionManager.getPortdtocm_r().setMsg(attachmentrtop_dtocm.getRole().getMsg());

		// Call connection manager receive function
		connectionManager.receiveDatabase();
	}

	public void transmitSMtoD() {
		// Put the message in the connector role required
		attachmentptor_smtod.getRole().setMsg(attachmentptor_smtod.getPort().getMsg());

		// The message is processed by the connector
		connectorSMD.processingSMtoD();

		// Put the message in database port required
		database.getPortsmtod_r().setMsg(attachmentrtop_smtod.getRole().getMsg());

		// Call server receive function
		database.receiveSecurityManager();
	}

	public void transmitDtoSM() {
		// Put the message in the connector role required
		attachmentptor_dtosm.getRole().setMsg(attachmentptor_dtosm.getPort().getMsg());

		// The message is processed by the connector
		connectorSMD.processingDtoSM();

		// Put the message in security manager port required
		securityManager.getPortdtosm_r().setMsg(attachmentrtop_dtosm.getRole().getMsg());

		// Call server receive function
		securityManager.receiveDatabase();
	}

	public void transmitCMtoSM() {
		// Put the message in the connector role required
		attachmentptor_cmtosm.getRole().setMsg(attachmentptor_cmtosm.getPort().getMsg());

		// The message is processed by the connector
		connectorCMSM.processingCMtoSM();

		// Put the message in security manager port required
		securityManager.getPortcmtosm_r().setMsg(attachmentrtop_cmtosm.getRole().getMsg());

		// Call server receive function
		securityManager.receiveConnectionManager();
	}

	public void transmitSMtoCM() {
		// Put the message in the connector role required
		attachmentptor_smtocm.getRole().setMsg(attachmentptor_smtocm.getPort().getMsg());

		// The message is processed by the connector
		connectorCMSM.processingSMtoCM();

		// Put the message in connection manager port required
		connectionManager.getPortsmtocm_r().setMsg(attachmentrtop_smtocm.getRole().getMsg());

		// Call server receive function
		connectionManager.receiveSecurityManager();
	}

	public void transmitConfigToCM() {
		// Put the message in the connection manager required port
		bindingConfigtoCM.getPortComponent().setMsg(bindingConfigtoCM.getPortConfiguration().getMsg());

		if (!connectionManager.isActive()) {
			try {
				connectionManager.sendSecurityManager(connectionManager.getPortcmserverconfig_r().getMsg());
				securityManager.receiveConnectionManager();
				database.receiveSecurityManager();
				securityManager.receiveDatabase();
				connectionManager.receiveSecurityManager();

				if (!connectionManager.isActive())
					connectionManager.getPortcmserverconfig_p().setMsg("Connexion error.");
				else
					connectionManager.getPortcmserverconfig_p().setMsg("Connexion success.");

			} catch (NoSuchElementException | IllegalArgumentException | IOException e) {
				e.printStackTrace();
			}
		} else {
			connectionManager.getPortcmserverconfig_p().setMsg("The message has been successfuly received !");
		}
		
		// At the end, send the message to the server component
		transmitCMToConfig();
	}

	public void transmitCMToConfig() {
		// Put the message in the configuration provided port
		bindingCMtoConfig.getPortConfiguration().setMsg(bindingCMtoConfig.getPortComponent().getMsg());
		try {
			Config.getInstance().processConfigMessage();
		} catch (NoSuchElementException | IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public Port getPortserverconfig_p() {
		return portserverconfig_p;
	}

	public void setPortserverconfig_p(Port portserverconfig_p) {
		this.portserverconfig_p = portserverconfig_p;
	}

	public Port getPortserverconfig_r() {
		return portserverconfig_r;
	}

	public void setPortserverconfig_r(Port portserverconfig_r) {
		this.portserverconfig_r = portserverconfig_r;
	}
}

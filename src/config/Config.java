package config;

import java.io.IOException;
import java.util.NoSuchElementException;

import utils.Attachment;

public class Config {
	
	private static Config INSTANCE;
	
	private Client client;
	private Attachment attachmentptor_ctos;
	private Attachment attachmentrtop_stoc;
	
	private Server server;
	private Attachment attachmentptor_stoc;
	private Attachment attachmentrtop_ctos;
	
	private ConnectorRPC connectorRPC;
	
	private Config() {
		client = new Client();
		server = new Server();
		connectorRPC = new ConnectorRPC();
		
		// Client required and provided attachments
		attachmentptor_ctos = new Attachment(client.getPortctos_p(), connectorRPC.getGluectos().getRequired());		
		attachmentrtop_stoc = new Attachment(client.getPortstoc_r(), connectorRPC.getGluestoc().getProvided());
		
		// Server required and provided attachments
		attachmentptor_stoc = new Attachment(server.getPortstoc_p(), connectorRPC.getGluestoc().getRequired());
		attachmentrtop_ctos = new Attachment(server.getPortctos_r(), connectorRPC.getGluectos().getProvided());
	}
	
	public static Config getInstance() throws NoSuchElementException, IllegalArgumentException, IOException {
		if (INSTANCE == null) {
			synchronized (Config.class) {
				if (INSTANCE == null) {
					INSTANCE = new Config();
				}
			}
		}

		return INSTANCE;
	}

	public void transmitCtoS() {
		// Put the message in the connectorRPC role required
		attachmentptor_ctos.getRole().setMsg(attachmentptor_ctos.getPort().getMsg());
		
		// The message is processed by RPC
		connectorRPC.processingCtoS();
		
		// Put the message in server port required
		server.getPortctos_r().setMsg(attachmentrtop_ctos.getRole().getMsg());
		
		// Call server receive function
		server.receive();
	}
	
	public void transmitStoC() {
		// Put the message in the connectorRPC role required
		attachmentptor_stoc.getRole().setMsg(attachmentptor_stoc.getPort().getMsg());
		
		// The message is processed by RPC
		connectorRPC.processingStoC();
		
		//Put the message in client port required
		client.getPortstoc_r().setMsg(attachmentrtop_stoc.getRole().getMsg());
		
		// Call the client receive function
		client.receive();
	}
	
	public Client getClient() {
		return this.client;
	}
}

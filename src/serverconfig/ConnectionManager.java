package serverconfig;

import java.io.IOException;
import java.util.NoSuchElementException;

import utils.Port;
import utils.Type;

public class ConnectionManager {
	private Port portcmtosm_p;
	private Port portsmtocm_r;
	private Port portcmtod_p;
	private Port portdtocm_r;
	
	private Port portcmserverconfig_p;
	private Port portcmserverconfig_r;

	public ConnectionManager() {
		portcmtosm_p = new Port("portcmtosm_p", Type.PROVIDED, null);
		portsmtocm_r = new Port("portsmtocm_r", Type.REQUIRED, null);
		portcmtod_p = new Port("portcmtod_p", Type.PROVIDED, null);
		portdtocm_r = new Port("portdtocm_r", Type.REQUIRED, null);
		
		portcmserverconfig_p = new Port("portcmserverconfig_p", Type.PROVIDED, null);
		portcmserverconfig_r = new Port("portcmserverconfig_r", Type.REQUIRED, null);
	}
	
	public void sendSecurityManager(String msg) throws NoSuchElementException, IllegalArgumentException, IOException {
		System.out.println("Message sent from connection manager : " + msg);
		portcmtosm_p.setMsg(msg);
		ServerConfig.getInstance().transmitCMtoSM();
	}

	public void receiveSecurityManager() {
		System.out.println("Message received from security manager : " + portsmtocm_r.getMsg());
	}
	
	public void sendDatabase(String msg) throws NoSuchElementException, IllegalArgumentException, IOException {
		System.out.println("Message sent from connection manager : " + msg);
		portcmtod_p.setMsg(msg);
		ServerConfig.getInstance().transmitCMtoD();
	}

	public void receiveDatabase() {
		System.out.println("Message received from database : " + portdtocm_r.getMsg());
	}

	public Port getPortcmtosm_p() {
		return portcmtosm_p;
	}

	public void setPortcmtosm_p(Port portcmtosm_p) {
		this.portcmtosm_p = portcmtosm_p;
	}

	public Port getPortsmtocm_r() {
		return portsmtocm_r;
	}

	public void setPortsmtocm_r(Port portsmtocm_r) {
		this.portsmtocm_r = portsmtocm_r;
	}

	public Port getPortcmtod_p() {
		return portcmtod_p;
	}

	public void setPortcmtod_p(Port portcmtod_p) {
		this.portcmtod_p = portcmtod_p;
	}

	public Port getPortdtocm_r() {
		return portdtocm_r;
	}

	public void setPortdtocm_r(Port portdtocm_r) {
		this.portdtocm_r = portdtocm_r;
	}

	public Port getPortcmserverconfig_p() {
		return portcmserverconfig_p;
	}

	public void setPortcmserverconfig_p(Port portcmserverconfig_p) {
		this.portcmserverconfig_p = portcmserverconfig_p;
	}

	public Port getPortcmserverconfig_r() {
		return portcmserverconfig_r;
	}

	public void setPortcmserverconfig_r(Port portcmserverconfig_r) {
		this.portcmserverconfig_r = portcmserverconfig_r;
	}

}

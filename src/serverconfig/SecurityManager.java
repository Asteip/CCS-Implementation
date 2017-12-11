package serverconfig;

import java.io.IOException;
import java.util.NoSuchElementException;

import utils.Port;
import utils.Type;

public class SecurityManager {
	private Port portsmtocm_p;
	private Port portcmtosm_r;
	private Port portsmtod_p;
	private Port portdtosm_r;

	public SecurityManager() {
		portsmtocm_p = new Port("portsmtocm_p", Type.PROVIDED, null);
		portcmtosm_r = new Port("portcmtosm_r", Type.REQUIRED, null);
		portsmtod_p = new Port("portsmtod_p", Type.PROVIDED, null);
		portdtosm_r = new Port("portdtosm_r", Type.REQUIRED, null);
	}
	
	public void sendConnectionManager(String msg) throws NoSuchElementException, IllegalArgumentException, IOException {
		System.out.println("Message sent from security manager : " + msg);
		portsmtocm_p.setMsg(msg);
		ServerConfig.getInstance().transmitSMtoCM();
	}

	public void receiveConnectionManager() {
		System.out.println("Message received from connection manager : " + portcmtosm_r.getMsg());
		
		try {
			sendDatabase(portcmtosm_r.getMsg());
		} catch (NoSuchElementException | IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendDatabase(String msg) throws NoSuchElementException, IllegalArgumentException, IOException {
		System.out.println("Message sent from security manager : " + msg);
		portsmtod_p.setMsg(msg);
		ServerConfig.getInstance().transmitSMtoD();
	}

	public void receiveDatabase() {
		System.out.println("Message received from database : " + portdtosm_r.getMsg());
		
		try {
			if(portdtosm_r.getMsg() == "active_connection")
				sendConnectionManager("active_connection");
		} catch (NoSuchElementException | IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public Port getPortsmtocm_p() {
		return portsmtocm_p;
	}

	public void setPortsmtocm_p(Port portsmtocm_p) {
		this.portsmtocm_p = portsmtocm_p;
	}

	public Port getPortcmtosm_r() {
		return portcmtosm_r;
	}

	public void setPortcmtosm_r(Port portcmtosm_r) {
		this.portcmtosm_r = portcmtosm_r;
	}

	public Port getPortsmtod_p() {
		return portsmtod_p;
	}

	public void setPortsmtod_p(Port portsmtod_p) {
		this.portsmtod_p = portsmtod_p;
	}

	public Port getPortdtosm_r() {
		return portdtosm_r;
	}

	public void setPortdtosm_r(Port portdtosm_r) {
		this.portdtosm_r = portdtosm_r;
	}
}

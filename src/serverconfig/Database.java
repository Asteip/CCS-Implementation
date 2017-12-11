package serverconfig;

import java.io.IOException;
import java.util.NoSuchElementException;

import utils.Port;
import utils.Type;

public class Database {
	private Port portdtocm_p;
	private Port portcmtod_r;
	private Port portdtosm_p;
	private Port portsmtod_r;
	
	private String password; 

	public Database() {
		portdtocm_p = new Port("portdtocm_p", Type.PROVIDED, null);
		portcmtod_r = new Port("portcmtod_r", Type.REQUIRED, null);
		portdtosm_p = new Port("portdtosm_p", Type.PROVIDED, null);
		portsmtod_r = new Port("portsmtod_r", Type.REQUIRED, null);
		
		password = "topsecret";
		
	}
	
	public void sendConnectionManager(String msg) throws NoSuchElementException, IllegalArgumentException, IOException {
		System.out.println("Message sent from database : " + msg);
		portdtocm_p.setMsg(msg);
		ServerConfig.getInstance().transmitDtoCM();
	}

	public void receiveConnectionManager() {
		System.out.println("Message received from connection manager : " + portcmtod_r.getMsg());
	}
	
	public void sendSecurityManager(String msg) throws NoSuchElementException, IllegalArgumentException, IOException {
		System.out.println("Message sent from database : " + msg);
		portdtosm_p.setMsg(msg);
		ServerConfig.getInstance().transmitDtoSM();
	}

	public void receiveSecurityManager() {
		System.out.println("Message received from security manager : " + portsmtod_r.getMsg());
		
		try {
			if(portsmtod_r.getMsg() == password)
				sendSecurityManager("active_connection");
		} catch (NoSuchElementException | IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public Port getPortdtocm_p() {
		return portdtocm_p;
	}

	public void setPortdtocm_p(Port portdtocm_p) {
		this.portdtocm_p = portdtocm_p;
	}

	public Port getPortcmtod_r() {
		return portcmtod_r;
	}

	public void setPortcmtod_r(Port portcmtod_r) {
		this.portcmtod_r = portcmtod_r;
	}

	public Port getPortdtosm_p() {
		return portdtosm_p;
	}

	public void setPortdtosm_p(Port portdtosm_p) {
		this.portdtosm_p = portdtosm_p;
	}

	public Port getPortsmtod_r() {
		return portsmtod_r;
	}

	public void setPortsmtod_r(Port portsmtod_r) {
		this.portsmtod_r = portsmtod_r;
	}
}

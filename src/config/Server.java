package config;

import java.io.IOException;
import java.util.NoSuchElementException;

import serverconfig.ServerConfig;
import utils.Port;
import utils.Type;

public class Server {
	private Port portstoc_p;
	private Port portctos_r;
	
	public Server() {		
		portstoc_p = new Port("portstoc_p", Type.PROVIDED, null);
		portctos_r = new Port("portctos_r", Type.REQUIRED, null);
	}

	public void send(String msg) throws NoSuchElementException, IllegalArgumentException, IOException {		
		System.out.println("Message sent from server : " + msg);
		portstoc_p.setMsg(msg);
		Config.getInstance().transmitStoC();
	}
	
	public void receive() {
		System.out.println("Message received from client : " + portctos_r.getMsg());
		
		try {
			ServerConfig.getInstance().getPortserverconfig_r().setMsg(portctos_r.getMsg());
			ServerConfig.getInstance().transmitConfigToCM();
		} catch (NoSuchElementException | IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public Port getPortstoc_p() {
		return portstoc_p;
	}

	public void setPortstoc_p(Port portstoc_p) {
		this.portstoc_p = portstoc_p;
	}

	public Port getPortctos_r() {
		return portctos_r;
	}

	public void setPortctos_r(Port portctos_r) {
		this.portctos_r = portctos_r;
	}
}

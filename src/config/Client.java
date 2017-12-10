package config;

import java.io.IOException;
import java.util.NoSuchElementException;

import utils.Port;
import utils.Type;

public class Client {
	private Port portctos_p;
	private Port portstoc_r;
	
	public Client() {		
		portctos_p = new Port("portctos_p", Type.PROVIDED, null);
		portstoc_r = new Port("portstoc_r", Type.REQUIRED, null);
	}

	public void send(String msg) throws NoSuchElementException, IllegalArgumentException, IOException {
		System.out.println("Message sent from client : " + msg);
		portctos_p.setMsg(msg);
		Config.getInstance().transmitCtoS();
	}
	
	public void receive() {
		System.out.println("Message received from server : " + portstoc_r.getMsg());
	}
	
	public Port getPortctos_p() {
		return portctos_p;
	}

	public void setPortctos_p(Port portctos_p) {
		this.portctos_p = portctos_p;
	}

	public Port getPortstoc_r() {
		return portstoc_r;
	}

	public void setPortstoc_r(Port portstoc_r) {
		this.portstoc_r = portstoc_r;
	}
}

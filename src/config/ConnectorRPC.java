package config;

import utils.Glue;
import utils.Role;
import utils.Type;

public class ConnectorRPC {
	private Glue gluectos;
	private Glue gluestoc;

	public ConnectorRPC() {

		// Create the glue client -> server

		Role rolegluectos_r = new Role("rolegluectos_r", Type.REQUIRED, null);
		Role rolegluectos_p = new Role("rolegluectos_p", Type.PROVIDED, null);

		this.gluectos = new Glue(rolegluectos_r, rolegluectos_p);

		// Create the glue server -> client

		Role rolegluestoc_r = new Role("rolegluestoc_r", Type.REQUIRED, null);
		Role rolegluestoc_p = new Role("rolegluestoc_p", Type.PROVIDED, null);

		this.gluestoc = new Glue(rolegluestoc_r, rolegluestoc_p);
	}

	public void processingCtoS() {
		String msg = this.gluectos.getRequired().getMsg();
		System.out.println("The message : " + msg + " is processing by RPC and will be sent to the server.");
		this.gluectos.getProvided().setMsg(msg);
		;
	}

	public void processingStoC() {
		String msg = this.gluestoc.getRequired().getMsg();
		System.out.println("The message : " + msg + " is processing by RPC and will be sent to the client.");
		this.gluestoc.getProvided().setMsg(msg);
		;
	}

	public Glue getGluectos() {
		return gluectos;
	}

	public void setGluectos(Glue gluectos) {
		this.gluectos = gluectos;
	}

	public Glue getGluestoc() {
		return gluestoc;
	}

	public void setGluestoc(Glue gluestoc) {
		this.gluestoc = gluestoc;
	}
}

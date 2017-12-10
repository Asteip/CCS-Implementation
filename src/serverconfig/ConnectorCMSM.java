package serverconfig;

import utils.Glue;
import utils.Role;
import utils.Type;

public class ConnectorCMSM {
	private Glue gluecmtosm;
	private Glue gluesmtocm;

	public ConnectorCMSM() {

		// Create the glue cm -> sm

		Role rolegluecmtosm_r = new Role("rolegluecmtosm_r", Type.REQUIRED, null);
		Role rolegluecmtosm_p = new Role("rolegluecmtosm_p", Type.PROVIDED, null);

		this.gluecmtosm = new Glue(rolegluecmtosm_r, rolegluecmtosm_p);

		// Create the glue sm -> cm

		Role rolegluesmtocm_r = new Role("rolegluesmtocm_r", Type.REQUIRED, null);
		Role rolegluesmtocm_p = new Role("rolegluesmtocm_p", Type.PROVIDED, null);

		this.gluesmtocm = new Glue(rolegluesmtocm_r, rolegluesmtocm_p);
	}

	public void processingCMtoSM() {
		String msg = this.gluecmtosm.getRequired().getMsg();
		System.out.println("The message : " + msg + " is processing by RPC and will be sent to the security manager.");
		this.gluecmtosm.getProvided().setMsg(msg);
	}

	public void processingSMtoCM() {
		String msg = this.gluesmtocm.getRequired().getMsg();
		System.out
				.println("The message : " + msg + " is processing by RPC and will be sent to the connection manager.");
		this.gluesmtocm.getProvided().setMsg(msg);
	}

	public Glue getGluecmtosm() {
		return gluecmtosm;
	}

	public void setGluecmtosm(Glue gluecmtosm) {
		this.gluecmtosm = gluecmtosm;
	}

	public Glue getGluesmtocm() {
		return gluesmtocm;
	}

	public void setGluesmtocm(Glue gluesmtocm) {
		this.gluesmtocm = gluesmtocm;
	}
}

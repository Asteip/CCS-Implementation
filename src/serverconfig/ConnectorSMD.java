package serverconfig;

import utils.Glue;
import utils.Role;
import utils.Type;

public class ConnectorSMD {
	private Glue gluesmtod;
	private Glue gluedtosm;

	public ConnectorSMD() {

		// Create the glue sm -> d

		Role rolegluesmtod_r = new Role("rolegluesmtod_r", Type.REQUIRED, null);
		Role rolegluesmtod_p = new Role("rolegluesmtod_p", Type.PROVIDED, null);

		this.gluesmtod = new Glue(rolegluesmtod_r, rolegluesmtod_p);

		// Create the glue d -> sm

		Role rolegluedtosm_r = new Role("rolegluedtosm_r", Type.REQUIRED, null);
		Role rolegluedtosm_p = new Role("rolegluedtosm_p", Type.PROVIDED, null);

		this.gluedtosm = new Glue(rolegluedtosm_r, rolegluedtosm_p);
	}

	public void processingSMtoD() {
		String msg = this.gluesmtod.getRequired().getMsg();
		System.out.println("The message : " + msg + " is processing by RPC and will be sent to the database.");
		this.gluesmtod.getProvided().setMsg(msg);
		;
	}

	public void processingDtoSM() {
		String msg = this.gluedtosm.getRequired().getMsg();
		System.out.println("The message : " + msg + " is processing by RPC and will be sent to the security manager.");
		this.gluedtosm.getProvided().setMsg(msg);
		;
	}

	public Glue getGluesmtod() {
		return gluesmtod;
	}

	public void setGluesmtod(Glue gluesmtod) {
		this.gluesmtod = gluesmtod;
	}

	public Glue getGluedtosm() {
		return gluedtosm;
	}

	public void setGluedtosm(Glue gluedtosm) {
		this.gluedtosm = gluedtosm;
	}

}

package serverconfig;

import utils.Glue;
import utils.Role;
import utils.Type;

public class ConnectorCMD {
	private Glue gluecmtod;
	private Glue gluedtocm;

	public ConnectorCMD() {

		// Create the glue cm -> d

		Role rolegluecmtod_r = new Role("rolegluecmtod_r", Type.REQUIRED, null);
		Role rolegluecmtod_p = new Role("rolegluecmtod_p", Type.PROVIDED, null);

		this.gluecmtod = new Glue(rolegluecmtod_r, rolegluecmtod_p);

		// Create the glue d -> cm

		Role rolegluedtocm_r = new Role("rolegluestoc_r", Type.REQUIRED, null);
		Role rolegluedtocm_p = new Role("rolegluestoc_p", Type.PROVIDED, null);

		this.gluedtocm = new Glue(rolegluedtocm_r, rolegluedtocm_p);
	}

	public void processingCMtoD() {
		String msg = this.gluecmtod.getRequired().getMsg();
		System.out.println("The message : " + msg + " is processing by RPC and will be sent to the database.");
		this.gluecmtod.getProvided().setMsg(msg);
	}

	public void processingDtoCM() {
		String msg = this.gluedtocm.getRequired().getMsg();
		System.out
				.println("The message : " + msg + " is processing by RPC and will be sent to the connection manager.");
		this.gluedtocm.getProvided().setMsg(msg);
	}

	public Glue getGluecmtod() {
		return gluecmtod;
	}

	public void setGluecmtod(Glue gluecmtod) {
		this.gluecmtod = gluecmtod;
	}

	public Glue getGluedtocm() {
		return gluedtocm;
	}

	public void setGluedtocm(Glue gluedtocm) {
		this.gluedtocm = gluedtocm;
	}

}

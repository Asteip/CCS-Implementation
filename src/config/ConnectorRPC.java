package config;

import utils.Glue;
import utils.Role;
import utils.Type;

public class ConnectorRPC {
	private Glue gluectos;
	private Glue gluestoc;
	
	public ConnectorRPC() {
		Role rolegluectos_r = new Role("rolegluectos_r", Type.REQUIRED, null);
		Role rolegluectos_p = new Role("rolegluectos_p", Type.PROVIDED, null);
		
		this.gluectos = new Glue(rolegluectos_r, rolegluectos_p);
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

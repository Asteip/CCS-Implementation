package utils;

public class Glue {
	private Role required;
	private Role provided;
	
	public Glue(Role required, Role provided) {
		if(required.getType() != Type.REQUIRED || provided.getType() != Type.PROVIDED)
			throw new IllegalArgumentException("Required must have type required and Provided must have type provided.");
			
		this.required = required;
		this.provided = provided;
	}

	public Role getRequired() {
		return required;
	}

	public void setRequired(Role required) {
		if(required.getType() != Type.REQUIRED)
			throw new IllegalArgumentException("Role required must have the type required.");
		
		this.required = required;
	}

	public Role getProvided() {
		return provided;
	}

	public void setProvided(Role provided) {
		if(required.getType() != Type.PROVIDED)
			throw new IllegalArgumentException("Role provided must have the type provided.");
		
		this.provided = provided;
	}
}

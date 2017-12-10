package utils;

public class Attachment {
	private Port port;
	private Role role;

	public Attachment(Port port, Role role) {
		if ((port.getType() == Type.PROVIDED && role.getType() == Type.PROVIDED)
				|| (port.getType() == Type.REQUIRED && role.getType() == Type.REQUIRED))
			throw new IllegalArgumentException("Role and port cannot have the same type.");

		this.port = port;
		this.role = role;
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		if (this.role != null && this.role.getType() == Type.PROVIDED && port.getType() == Type.PROVIDED)
			throw new IllegalArgumentException("The corresponding role cannot be provided.");
		if (this.role != null && this.role.getType() == Type.REQUIRED && port.getType() == Type.REQUIRED)
			throw new IllegalArgumentException("The corresponding role cannot be required.");

		this.port = port;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		if (this.port != null && this.port.getType() == Type.PROVIDED && role.getType() == Type.PROVIDED)
			throw new IllegalArgumentException("The corresponding role cannot be provided.");
		if (this.port != null && this.port.getType() == Type.REQUIRED && role.getType() == Type.REQUIRED)
			throw new IllegalArgumentException("The corresponding role cannot be required.");

		this.role = role;
	}
}

package utils;

public class Binding {
	private Port portComponent;
	private Port portConfiguration;

	public Binding(Port portComponent, Port portConfiguration) {
		if ((portComponent.getType() == Type.PROVIDED && portConfiguration.getType() == Type.REQUIRED)
				|| (portComponent.getType() == Type.REQUIRED && portConfiguration.getType() == Type.PROVIDED))
			throw new IllegalArgumentException("Ports must have the same type.");

		this.portComponent = portComponent;
		this.portConfiguration = portConfiguration;
	}

	public Port getPortComponent() {
		return portComponent;
	}

	public void setPortComponent(Port portComponent) {
		if (this.portConfiguration != null && this.portConfiguration.getType() == Type.PROVIDED
				&& portComponent.getType() == Type.REQUIRED)
			throw new IllegalArgumentException("The corresponding port must be provided.");
		if (this.portConfiguration != null && this.portConfiguration.getType() == Type.REQUIRED
				&& portComponent.getType() == Type.PROVIDED)
			throw new IllegalArgumentException("The corresponding port must be required.");

		this.portComponent = portComponent;
	}

	public Port getPortConfiguration() {
		return portConfiguration;
	}

	public void setPortConfiguration(Port portConfiguration) {
		if (this.portComponent != null && this.portComponent.getType() == Type.PROVIDED
				&& portConfiguration.getType() == Type.REQUIRED)
			throw new IllegalArgumentException("The corresponding port must be provided.");
		if (this.portComponent != null && this.portComponent.getType() == Type.REQUIRED
				&& portConfiguration.getType() == Type.PROVIDED)
			throw new IllegalArgumentException("The corresponding port must be required.");

		this.portConfiguration = portConfiguration;
	}
}

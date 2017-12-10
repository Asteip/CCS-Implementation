package concepts.component;

import java.util.ArrayList;
import java.util.List;

import concepts.GeneralComponent;
import concepts.configuration.InterfaceConfigurationProvided;
import concepts.configuration.InterfaceConfigurationRequired;

public class Component implements GeneralComponent {

	private List<IProperty> _properties;
	private List<InterfaceComponentProvided> _provideds;
	private List<InterfaceComponentRequired> _requireds;
	
	public Component() {
		_properties = new ArrayList<IProperty>();
		_provideds = new ArrayList<InterfaceComponentProvided>();
		_requireds = new ArrayList<InterfaceComponentRequired>();
	}

	@Override
	public void transmit(String from, String to, String msg) {
		// TODO Auto-generated method stub
		
		
		
		

	}

	public void addRequired(InterfaceComponentRequired required) {
		_requireds.add(required);
	}

	public void removeRequired(InterfaceComponentRequired required) {
		_requireds.remove(required);
	}

	public InterfaceComponentRequired getRequired(int index) {
		return _requireds.get(index);
	}

	public void addProvided(InterfaceComponentProvided required) {
		_provideds.add(required);
	}

	public void removeProvided(InterfaceComponentProvided required) {
		_provideds.remove(required);
	}

	public InterfaceComponentProvided getProvided(int index) {
		return _provideds.get(index);
	}

}

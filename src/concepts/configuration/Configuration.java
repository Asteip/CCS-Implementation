package concepts.configuration;

import java.util.ArrayList;
import java.util.List;

import concepts.GeneralComponent;
import concepts.GeneralConnector;
import concepts.links.ILink;

public class Configuration implements GeneralComponent, GeneralConnector {

	private List<InterfaceConfigurationRequired> _requireds;
	private List<InterfaceConfigurationProvided> _provideds;
	private List<GeneralComponent> _components;
	private List<GeneralConnector> _connectors;
	private List<ILink> _links;

	public Configuration() {
		_requireds = new ArrayList<InterfaceConfigurationRequired>();
		_provideds = new ArrayList<InterfaceConfigurationProvided>();
		_components = new ArrayList<GeneralComponent>();
		_connectors = new ArrayList<GeneralConnector>();
		_links = new ArrayList<ILink>();
	}
	
	@Override
	public void transmit(String from, String to, String msg) {
		
		
		// TODO
		
		
		
	}
	
	public void addRequired(InterfaceConfigurationRequired required) {
		_requireds.add(required);
	}
	
	public void removeRequired(InterfaceConfigurationRequired required) {
		_requireds.remove(required);
	}
	
	public InterfaceConfigurationRequired getRequired(int index) {
		return _requireds.get(index);
	}
	
	public void addProvided(InterfaceConfigurationProvided required) {
		_provideds.add(required);
	}
	
	public void removeProvided(InterfaceConfigurationProvided required) {
		_provideds.remove(required);
	}
	
	public InterfaceConfigurationProvided getProvided(int index) {
		return _provideds.get(index);
	}
	
	public void addComponent(GeneralComponent required) {
		_components.add(required);
	}
	
	public void removeComponent(GeneralComponent required) {
		_components.remove(required);
	}
	
	public GeneralComponent getComponent(int index) {
		return _components.get(index);
	}
	
	public void addConnector(GeneralConnector required) {
		_connectors.add(required);
	}
	
	public void removeConnector(GeneralConnector required) {
		_connectors.remove(required);
	}
	
	public GeneralConnector getConnector(int index) {
		return _connectors.get(index);
	}
	
	public void addLink(ILink required) {
		_links.add(required);
	}
	
	public void removeLink(ILink required) {
		_links.remove(required);
	}
	
	public ILink getLink(int index) {
		return _links.get(index);
	}
}

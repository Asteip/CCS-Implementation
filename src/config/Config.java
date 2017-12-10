package config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import utils.Attachment;

public class Config {
	
	private static Config INSTANCE;
	
	private List<Client> clients;
	private Attachment attachmentptor_ctos;
	private Attachment attachmentrtop_stoc;
	
	private ConnectorRPC connectorRPC;
	
	private Config() {
		clients = new ArrayList<Client>();
		attachmentptor_ctos = new Attachment(null, connectorRPC.getGluectos().getRequired());
		//attachmentrtop_stoc = new Attachment(null, connectorRPC.get);
		
		connectorRPC = new ConnectorRPC();
	}
	
	public static Config getInstance() throws NoSuchElementException, IllegalArgumentException, IOException {
		if (INSTANCE == null) {
			synchronized (Config.class) {
				if (INSTANCE == null) {
					INSTANCE = new Config();
				}
			}
		}

		return INSTANCE;
	}

	public void transmitCtoS(String id) {
		Client from = null;
		
		for(Client client : clients) {
			if (client.getId() == id) {
				from = client;
				break;
			}
		}
		
		if(from != null) {
			// String msg = from.getPortctos_p().getMsg();
			
			attachmentptor_ctos.setPort(from.getPortctos_p());
			
			
		}
	}
}

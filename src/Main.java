import java.io.IOException;
import java.util.NoSuchElementException;

import config.Client;
import config.Config;

public class Main {

	public static void main(String[] args) {
		try {
			Client client = Config.getInstance().getClient();
			client.send("Salut toi !");			
		} catch (NoSuchElementException | IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}

}

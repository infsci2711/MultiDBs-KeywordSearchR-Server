package edu.pitt.sis.infsci2711.keywordapi;

import java.io.File;

import edu.pitt.sis.infsci2711.multidbs.utils.JerseyJettyServer;
import edu.pitt.sis.infsci2711.multidbs.utils.PropertiesManager;

public class KeywordServer {
	
	private final static String PROPERTY_PORT = "port";
	private final static int DEFAULT_PORT = 7654;
	
	
	public static void main(final String[] args) throws Exception {
		
		if (args.length > 0) {
			String propertiesFilePath = args[0];
			File propertiesFile = new File(propertiesFilePath);
			PropertiesManager.getInstance().loadProperties(propertiesFile);
		}
		
		final JerseyJettyServer server = new JerseyJettyServer(PropertiesManager.getInstance().getIntProperty(PROPERTY_PORT,DEFAULT_PORT),
				"edu.pitt.sis.infsci2711.keyword.rest");
		server.start();
		
		//JerseyJettyServer server = new JerseyJettyServer(7654, "edu.pitt.sis.infsci2711.keyword.rest");
		//server.start();
		
	
	}
}

package edu.pitt.sis.infsci2711.keywordapi;

import edu.pitt.sis.infsci2711.multidbs.utils.JerseyJettyServer;

public class TutorialServer {
	
	public static void main(final String[] args) throws Exception {
		JerseyJettyServer server = new JerseyJettyServer(7654, "edu.pitt.sis.infsci2711.keyword.rest");
		server.start();

	
	}
}

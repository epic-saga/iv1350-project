package se.kth.iv1350.sagah.startup;

import java.io.IOException;
import se.kth.iv1350.sagah.controller.Controller;
import se.kth.iv1350.sagah.view.View;
import se.kth.iv1350.sagah.integration.IntegrationHandler;

public class Main {

	/*	Used to start up application */

	public static void main(String args[]) throws IOException{
		IntegrationHandler integr = new IntegrationHandler();
		Controller contr = new Controller(integr);
		new View(contr).exampleRun();
	}
}

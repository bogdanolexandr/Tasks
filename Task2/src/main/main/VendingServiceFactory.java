package main;

import service.VendingMachine;
import service.VendingService;

public class VendingServiceFactory {

	public static VendingService getVendingMachine() {
		return new VendingMachine();
	}
	
}

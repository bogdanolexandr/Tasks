package main;

import domain.Bill;
import domain.Item;
import domain.Response;
import service.VendingService;

public class Main {

	public static void main(String[] args) {
		
		VendingService vendingMachine = VendingServiceFactory.getVendingMachine();
		Item item = Item.DVD;
		vendingMachine.chooseItem(item);
		vendingMachine.makeDeposite(Bill.TWENTY.nominal());
		vendingMachine.makeDeposite(Bill.TWENTY.nominal());
		vendingMachine.makeDeposite(Bill.FIVE.nominal());
		vendingMachine.makeDeposite(Bill.ONE.nominal());
		Response response = vendingMachine.confirmPurchase();
		
		System.out.println("you have bought " + response.getItem());
		System.out.println("your change " + response.getChange());
		

	}

}

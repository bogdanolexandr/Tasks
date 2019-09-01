package service;

import java.util.Set;

import domain.Item;
import domain.Response;
import domain.Status;
import exception.NoSuchItemException;
import exception.NonCorrectBillException;
import exception.NotEnoughDepositeException;

public interface VendingService {

	Set<Item> getAvailableItems();

	void chooseItem(Item item) throws NoSuchItemException;

	void makeDeposite(int count) throws NonCorrectBillException;

	int refund();

	Response confirmPurchase() throws NotEnoughDepositeException;
	
	void reset();
	
	int getEarnedMoney();
	
	Status getStatus();

}

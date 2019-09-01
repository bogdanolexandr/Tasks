package service;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import domain.Item;
import domain.Response;
import domain.Status;
import exception.NoSuchItemException;
import exception.NonCorrectBillException;
import exception.NotEnoughDepositeException;

public class VendingServiceTest {

	private VendingService service = new VendingMachine();

	@Test
	public void testBuyItemWithExactSumOfMoney() {
		Item item = Item.DVD;
		service.chooseItem(item);
		service.makeDeposite(20);
		service.makeDeposite(20);
		service.makeDeposite(5);
		Response response = service.confirmPurchase();
		int actualChange = response.getChange();
		Item actualItem = response.getItem();
		assertEquals(0, actualChange);
		assertEquals(Item.DVD,actualItem);
	}
	
	@Test
	public void testBuyItemWithMoreSumOfMoney() {
		Item item = Item.SPEAKER;
		service.chooseItem(item);
		service.makeDeposite(20);
		service.makeDeposite(10);
		service.makeDeposite(5);
		service.makeDeposite(1);
		Response response = service.confirmPurchase();
		int actualChange = response.getChange();
		Item actualItem = response.getItem();
		assertEquals(1, actualChange);
		assertEquals(Item.SPEAKER,actualItem);
	}
	
	@Test
	public void testRefund() {
		Item item = Item.HEADSET;
		service.chooseItem(item);
		service.makeDeposite(20);
		service.makeDeposite(20);
		service.makeDeposite(20);
		service.makeDeposite(5);
		int actual = service.refund();
		assertEquals(65,actual);
	}
	
	@Test
	public void testResetService() {
		Item item = Item.SPEAKER;
		service.chooseItem(item);
		service.makeDeposite(20);
		service.makeDeposite(10);
		service.makeDeposite(5);
		service.confirmPurchase();
		service.reset();
		Status status = service.getStatus();
		Map<Item,Integer> store = status.getStoreStatus();
		assertEquals(10, store.get(item).intValue());
	}
	
	@Test(expected = NotEnoughDepositeException.class)
	public void testNotEnoughMoney() {
		Item item = Item.DVD;
		service.chooseItem(item);
		service.makeDeposite(5);
		service.makeDeposite(1);
		service.confirmPurchase();
	}
	
	@Test(expected = NonCorrectBillException.class)
	public void testNonCorrectBill() {
		Item item = Item.DVD;
		service.chooseItem(item);
		service.makeDeposite(30);
	}
	
	@Test(expected = NoSuchItemException.class)
	public void testNonCorrectItem() {
		Item item = Item.SPEAKER;
		service.getStatus().getStoreStatus().put(item, 0);
		service.chooseItem(item);
	}

}

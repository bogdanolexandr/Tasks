package service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Item;
import domain.Response;
import domain.Status;
import exception.NoSuchItemException;
import exception.NonCorrectBillException;
import exception.NotEnoughDepositeException;
import repository.ItemRepository;

public class VendingMachine implements VendingService {

	private int allEarnedMoney;
	private Set<Integer> correctBills = Stream.of(1, 5, 10, 20).collect(Collectors.toSet());
	private ItemRepository itemRepository = new ItemRepository();

	private Item chosenItem;
	private int deposite = 0;

	@Override
	public Set<Item> getAvailableItems() {
		return itemRepository.getAllAvailableItemTypes();
	}

	@Override
	public void chooseItem(Item item) throws NoSuchItemException {
		if (itemRepository.isAvailable(item)) {
			chosenItem = item;
		} else {
			throw new NoSuchItemException();
		}
	}

	@Override
	public void makeDeposite(int bill) throws NonCorrectBillException {
		if (isCorrectBill(bill)) {
			deposite += bill;
		} else {
			throw new NonCorrectBillException();
		}
	}

	@Override
	public int refund() {
		int cash = deposite;
		clearState();
		return cash;
	}

	@Override
	public Response confirmPurchase() throws NotEnoughDepositeException {
		if (!isEnoughDeposite()) {
			throw new NotEnoughDepositeException();
		}
		int change = deposite - chosenItem.getPrice();
		allEarnedMoney += (deposite - change);
		itemRepository.decrease(chosenItem);
		Response response = new Response(chosenItem, change);
		clearState();
		return response;
	}

	@Override
	public void reset() {
		itemRepository.init();
	}

	@Override
	public int getEarnedMoney() {
		return allEarnedMoney;
	}

	private boolean isCorrectBill(int bill) {
		if (correctBills.contains(bill)) {
			return true;
		}
		return false;
	}

	private boolean isEnoughDeposite() {
		if (deposite - chosenItem.getPrice() >= 0) {
			return true;
		}
		return false;
	}

	private void clearState() {
		chosenItem = null;
		deposite = 0;
	}
	
	@Override
	public Status getStatus() {
		return new Status(allEarnedMoney, itemRepository.getStore());
	}

}

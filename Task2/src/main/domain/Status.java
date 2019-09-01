package domain;

import java.util.Map;

public class Status {

	private int allEarnedMoney;
	private Map<Item, Integer> storeStatus;

	public Status(int allEarnedMoney, Map<Item, Integer> storeStatus) {
		this.allEarnedMoney = allEarnedMoney;
		this.storeStatus = storeStatus;
	}

	public int getAllEarnedMoney() {
		return allEarnedMoney;
	}

	public Map<Item, Integer> getStoreStatus() {
		return storeStatus;
	}

}

package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import domain.Item;

public class ItemRepository {

	private Map<Item, Integer> store = new HashMap<>();

	public ItemRepository() {
		init();
	}
	
	public void init() {
		for (Item item : Item.values()) {
			store.put(item, 10);
		}
	}

	public boolean isAvailable(Item data) {
		return store.get(data) > 0;
	}

	public Set<Item> getAllAvailableItemTypes() {
		return store.keySet();
	}

	public void decrease(Item data) {
		int count = store.get(data);
		count--;
		store.put(data, count);
	}

	public void put(Item data, int count) {
		store.put(data, count);
	}

	public Map<Item, Integer> getStore() {
		return store;
	}
}

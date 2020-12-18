package com.demo.salestax.model;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Cart {

	private static final String DECIMAL_FORMAT = "###.00";
	private final Map<Item, Integer> items = new LinkedHashMap<Item, Integer>();

	DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);

	public void addItem(Item item, int count) {
		items.put(item, count);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	public void clearItems() {
		items.clear();
	}

	public Set<Item> getItems() {
		return items.keySet();
	}

	public int getQuantity(Item item) {
		return items.get(item);
	}

}

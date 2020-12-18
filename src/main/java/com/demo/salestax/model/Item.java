package com.demo.salestax.model;


public class Item  {

	private String itemName;
	private boolean isImportedItem = false;
	private boolean isExemptItem = false;
	private double price;
	private double tax;

	public Item(String itemName, double originalPrice) {
		this.itemName = itemName;
		this.price = originalPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isImportedItem() {
		return isImportedItem;
	}

	public void setImportedItem(boolean isImportedItem) {
		this.isImportedItem = isImportedItem;
	}

	public boolean isExemptItem() {
		return isExemptItem;
	}

	public void setExemptItem(boolean isExemptItem) {
		this.isExemptItem = isExemptItem;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public int hashCode() {
		return itemName.hashCode() + new Integer((int) (price * 100));
	}
}
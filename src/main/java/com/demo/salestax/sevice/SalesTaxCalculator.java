package com.demo.salestax.sevice;

import com.demo.salestax.model.Item;
import com.demo.salestax.util.ItemUtil;

public class SalesTaxCalculator {

	final static double rate = 0.1;

	public static double calulateTax(Item item) {
		double tax = ItemUtil.nearest5Percent(item.getPrice() * rate);
		return tax;
	}

}
package com.demo.salestax.sevice;

import com.demo.salestax.model.Item;
import com.demo.salestax.util.ItemUtil;

public class ImportTaxCalculator {

	final static double rate = 0.05;
	
	
	public static double calulateTax(Item item) {
		double tax = ItemUtil.nearest5Percent(item.getPrice() * rate);
		return tax;
	}
}
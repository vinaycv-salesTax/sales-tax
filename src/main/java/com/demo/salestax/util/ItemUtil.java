package com.demo.salestax.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class ItemUtil {
	

	private static Set<String> exemptItems = null;
	
	private static final String DECIMAL_FORMAT = "###.00";
	
	public static DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
	
	static {
		exemptItems = new HashSet<String>();
		exemptItems.add("book");
		exemptItems.add("headache pills");
		exemptItems.add("packet of headache pills");
		exemptItems.add("box of imported chocolates");
		exemptItems.add("imported box of chocolates");
		exemptItems.add("box of chocolates");
		exemptItems.add("chocolate");
		exemptItems.add("chocolate bar");
		exemptItems.add("pills");
	}

	static public double nearest5Percent(double amount) {

		return new BigDecimal(Math.ceil(amount * 20) / 20).setScale(2, RoundingMode.HALF_UP).doubleValue();

	}

	public static double roundPrice(double amount) {

		return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();

	}

	public static boolean isExempt(String name) {
		return exemptItems.contains(name);
	}

	
}
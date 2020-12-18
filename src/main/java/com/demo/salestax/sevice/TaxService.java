package com.demo.salestax.sevice;

import com.demo.salestax.model.Cart;
import com.demo.salestax.model.Item;
import com.demo.salestax.util.ItemUtil;

public class TaxService {
	

	public static void calculateTax(Cart cart) {

		for (Item item : cart.getItems()) {

			double tax = 0;
			if (!item.isExemptItem()) {
				tax += SalesTaxCalculator.calulateTax(item);
			}
			if (item.isImportedItem()) {
				tax += ImportTaxCalculator.calulateTax(item);
			}
			item.setTax(tax);
		}

	}
	
	public static void printInvoice(Cart cart) {
		
		double tax = 0;
		double total = 0;
		System.out.println("=====================  Invoice ==========================");
		for (Item item : cart.getItems()) {
			int qty = cart.getQuantity(item);
			double itemTax = qty * item.getTax();
			tax += itemTax;
			double price = itemTax + (qty * item.getPrice());
			total += price;
			System.out.println(qty + " " + item.getItemName() + ": " + ItemUtil.df.format(price));
		}
		total = ItemUtil.roundPrice(total);
		System.out.println("Sales Taxes: " + ItemUtil.df.format(tax));
		System.out.println("Total: " + ItemUtil.df.format(total));
		System.out.println();
		System.out.println("=====================  Invoice ==========================");
	}

}

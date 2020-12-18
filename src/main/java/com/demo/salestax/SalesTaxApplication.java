package com.demo.salestax;

import com.demo.salestax.model.Cart;
import com.demo.salestax.sevice.CartService;
import com.demo.salestax.sevice.TaxService;

public class SalesTaxApplication {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.err.println("Please provide required arguments.");
			System.err.println("Run as command: java -jar jarname filename1 filename2");
		}

		for (String order : args) {
			try {
				Cart cart = CartService.buildCart(order);
				CartService.printOrder(cart);
				TaxService.calculateTax(cart);
				TaxService.printInvoice(cart);
			} catch (Exception e) {

				System.err.println("Error while processing order : " +  e.getMessage());
			}
		}
	}
}

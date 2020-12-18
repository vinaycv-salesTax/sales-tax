package com.demo.salestax.sevice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.demo.salestax.model.Cart;
import com.demo.salestax.model.Item;
import com.demo.salestax.util.ItemParser;
import com.demo.salestax.util.ItemUtil;



public class CartService {
	
	
	public static Cart buildCart(String order) throws Exception {
		Cart cart = new Cart();
		try {
			BufferedReader in = new BufferedReader(new FileReader(order));
			String str;
			while ((str = in.readLine()) != null) {
				if (ItemParser.matches(str) && !str.isEmpty())
					cart.addItem(ItemParser.parser(str), ItemParser.count(str));
				else if (!str.isEmpty())
					System.err.println("wrong item: " + str);
			}
			in.close();
		} catch (IOException e) {
			throw new Exception("Not a valid order file : "+order);
		}
		return cart;
	}
	
	public static void printOrder(Cart cart) {
		
		System.out.println("=====================  Order ============================");
		for (Item item : cart.getItems()) {
			System.out.println(
					cart.getQuantity(item) + " " + item.getItemName() + " at " + ItemUtil.df.format(item.getPrice()));
		}
		System.out.println("=====================  Order ============================");
		
	}

}

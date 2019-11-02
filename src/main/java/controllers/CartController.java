package controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import models.Cart;
import models.Product;

public class CartController {

	public static void addProduct(Cart cart, Product product, Integer qnt) {
		Map<Product, Integer> set = cart.getProducts();
		if (set.containsKey(product)) {
			qnt += cart.getProducts().get(product);
		}
		cart.getProducts().put(product, qnt);
		CartController.countCartSize(cart);
		CartController.countTotalCost(cart);
	}
	
	public static void setProductQnt(Cart cart, Product product, Integer qnt) {
		Map<Product, Integer> set = cart.getProducts();
		
		if (set.containsKey(product)) {
			cart.getProducts().put(product, qnt);
		}
		cart.getProducts().put(product, qnt);
		CartController.countCartSize(cart);
		CartController.countTotalCost(cart);
	}

	public static void removeProduct(Cart cart, Product product, Integer qnt) {
		Set<Product> set = cart.getProducts().keySet();
		if (set.contains(product)) {
			if (qnt >= cart.getProducts().get(product)) {
				qnt = cart.getProducts().get(product) - qnt;
				cart.getProducts().put(product, qnt);
			} else {
				removeProductFully(cart, product);
			}
			CartController.countCartSize(cart);
			CartController.countTotalCost(cart);
		}
	}

	public static void countTotalCost(Cart cart) {
		Set<Product> set = cart.getProducts().keySet();
		int total = 0;
		for (Product product : set) {
			total += product.getPrice() * cart.getProducts().get(product);
		}
		cart.setTotalCost(total);
	}

	public static void removeProductFully(Cart cart, Product product) {
		cart.getProducts().remove(product);
		CartController.countCartSize(cart);
		CartController.countTotalCost(cart);
	}

	public static void cleanCart(Cart cart) {
		cart.setProducts(new HashMap<Product, Integer>());
		cart.setTotalCost(0);
	}
	
	public static void countCartSize(Cart cart) {
		Set<Product> set = cart.getProducts().keySet();
		int size = 0;
		for (Product product : set) {
			size += cart.getProducts().get(product);
		}
		cart.setSize(size);
	}
}

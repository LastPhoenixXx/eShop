package models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Product, Integer> products;
	int totalCost;
	int size;

	public Cart() {
		super();
		this.products = new HashMap();
	}

	public Cart(Map<Product, Integer> products, int totalCost, int size) {
		super();
		this.products = products;
		this.totalCost = totalCost;
		this.size = size;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}
	

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}

	
	
	
	
}

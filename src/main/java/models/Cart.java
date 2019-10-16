package models;

import java.util.List;

public class Cart {
	private List<Product> products;

	
	
	public Cart(List<Product> products) {
		super();
		this.products = products;
	}

	public Cart() {
		super();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProduts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}

	
}

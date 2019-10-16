package models;

import java.util.List;

public class Cart {
	private List<Product> produts;

	
	
	public Cart(List<Product> produts) {
		super();
		this.produts = produts;
	}

	public Cart() {
		super();
	}

	public List<Product> getProduts() {
		return produts;
	}

	public void setProduts(List<Product> produts) {
		this.produts = produts;
	}

	@Override
	public String toString() {
		return "Cart [produts=" + produts + "]";
	}

	
}

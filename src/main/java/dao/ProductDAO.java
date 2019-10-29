package dao;

import java.util.List;
import models.Product;

public interface ProductDAO {
	public List<Product> getProductList();
	public Product getProductById(long id);
	public List<Product> getProductByCategory(int category);
	public Product getOneProductByCategory(int category);
}

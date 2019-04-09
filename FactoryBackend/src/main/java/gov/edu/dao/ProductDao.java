package gov.edu.dao;

import java.util.List;

import gov.edu.model.Product;

public interface ProductDao 
{
	   public boolean addProduct(Product product);
	   public boolean deleteProduct(Product product);
	   public boolean updateProduct(Product product);
	   public List<Product> listProducts();
	   public Product getProduct(int proId);

}

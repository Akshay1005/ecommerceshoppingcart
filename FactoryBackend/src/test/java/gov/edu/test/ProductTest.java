package gov.edu.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gov.edu.dao.ProductDao;
import gov.edu.model.Product;

public class ProductTest {
	@Autowired
	static ProductDao productDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("gov.edu");
	    context.refresh();
	    
	    productDao=(ProductDao) context.getBean("productDao");
	}
	
	//@Ignore
	@Test
	public void test() 
	{
		Product product=new Product();
		product.setProName("Rolex");
		product.setCategoryID(102);
		product.setProprice(30000);
		product.setStock(20);
		product.setSupplierId(3);
		product.setProDesc("SmartWatch with Water proof and calling system");
		
		assertTrue("Problem in adding the product",productDao.addProduct(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDao.getProduct(69);
		
		assertTrue("Problem in deleting product",productDao.deleteProduct(product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDao.getProduct(103);
		product.setCategoryID(100);
		product.setProprice(25000);
		product.setStock(20);
		product.setSupplierId(1);
		product.setProDesc("SmartLaptop with latest Generations and OS");
		
		assertTrue("Problem in updating product",productDao.updateProduct(product));
	}
}
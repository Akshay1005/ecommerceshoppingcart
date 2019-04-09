package gov.edu.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gov.edu.dao.CategoryDao;
import gov.edu.model.Category;

public class CategoryUnitTest
{
	@Autowired
	static CategoryDao categoryDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("gov.edu");
	    context.refresh();
	    
	    categoryDao=(CategoryDao) context.getBean("categoryDao");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Watches");
		category.setCategoryDesc("Rolex");
		
		assertTrue("Problem in adding the category",categoryDao.addCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDao.getCategory(100);
		
		assertTrue("Problem in deleting category",categoryDao.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDao.getCategory(100);
		category.setCategoryDesc("Lenovo");
		
		assertTrue("Problem in updating category",categoryDao.updateCategory(category));
	}

}

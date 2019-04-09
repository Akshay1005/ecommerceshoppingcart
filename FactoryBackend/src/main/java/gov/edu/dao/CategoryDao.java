package gov.edu.dao;

import java.util.List;

import gov.edu.model.Category;

public interface CategoryDao {

	   public boolean addCategory(Category category);
	   public boolean deleteCategory(Category category);
	   public boolean updateCategory(Category category);
	   public List<Category> listCategories();
	   public Category getCategory(int categoryID);

}

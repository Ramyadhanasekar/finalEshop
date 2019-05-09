package com.ecomm.DAO;



import java.util.List;

import com.ecomm.model.Category;

public interface CategoryDAO 
{
	public boolean addCategory(Category category);
	
	public List<Category> getCategories();
	public Category getCategory(int categoryId);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	

}

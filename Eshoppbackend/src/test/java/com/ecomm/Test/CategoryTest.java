package com.ecomm.Test;




import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.CategoryDAO;
import com.ecomm.model.Category;
@Transactional
public class CategoryTest {
	
		static CategoryDAO categoryDAO;

		@BeforeClass
		public static void executeFirst()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.ecomm");
			context.refresh();
			
			categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		}

		@Test
		public void addCategoryTest()
		{
			Category category=new Category();
			
			category.setCatname("Fantasy");
			category.setCatdesc("Histroy is the discovery, collection, organization, and presentation of information about past events.");
			assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
		}
		
		@Test
		public void listCategoriesTest()
		{
			List<Category> listCategories=categoryDAO.getCategories();
			assertNotNull("No Categories",listCategories);
			
			for(Category category:listCategories)
			{
				System.out.print(category.getCatid()+":::");
				System.out.print(category.getCatname()+":::");
				System.out.println(category.getCatdesc());
			}
		}
		/*@Ignore
		@Test
		public void getCategoryTest()
		{
			assertNotNull("Problem in get Category",categoryDAO.getCategory(2));
		}
		
		*/
		
		@Test
		public void deleteCategoryTest()
		{
			Category category=categoryDAO.getCategory(2);
			assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
		}
	   
		
		@Test
		public void updateCategoryTest()
		{
			Category category=categoryDAO.getCategory(1);
			category.setCatname("Awesome");
			assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
		}

		
		
}

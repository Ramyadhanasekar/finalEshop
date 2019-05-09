package com.ecomm.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.DAO.CategoryDAO;
import com.ecomm.model.Category;

@Controller
public class CategoryController
{
	@Autowired
	 CategoryDAO categoryDAO;
	
	@RequestMapping(value= "/Categorypage", method = RequestMethod.GET)
	public String showCategory(Model m)
	{
		List<Category> listCat = categoryDAO.getCategories();
	m.addAttribute("listCategories", listCat);

	for (Category category : listCat) {
		System.out.println(category.getCatname() + ",");
		System.out.println(category.getCatdesc() + ",");
		System.out.println(category.getCatid() + ",");
		
	}
	
	
		return "Categorypage";
	}

	
	  @RequestMapping(value = "/InsertCategory", method = RequestMethod.POST)
	  public String insertCategoryData(@RequestParam("catname") String catname, @RequestParam("catdesc") String catdesc,Model m) 
	  {
		  Category category = new Category(); 
		  category.setCatname(catname); 
		  category.setCatdesc(catdesc);
	  
		  categoryDAO.addCategory(category); 
			List<Category> listCategories = categoryDAO.getCategories();
			m.addAttribute("listCategories", listCategories);
			
			
		  
		  return "Categorypage"; 
		  
	  }
	  
	  @RequestMapping("/deleteCategory/{categoryId}")
		public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m)
		{
			Category category=categoryDAO.getCategory(categoryId);
			
			categoryDAO.deleteCategory(category);
			
			List<Category> listCategories=categoryDAO.getCategories();
			m.addAttribute("listCategories",listCategories);
			
			return "Categorypage";
		}

		@RequestMapping("/updateCategory/{catid}")
		public String updateCategory(@PathVariable("catid") int catid,Model m)
		{
			Category category=categoryDAO.getCategory(catid);
			
			
			List<Category> listCat=categoryDAO.getCategories();
			m.addAttribute("listCategories",listCat);
			m.addAttribute("categoryInfo",category);
			
			return "UpdateCategory";
		}
		
		@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
		public String updateCategoryInDB(@RequestParam("catid") int categoryId,@RequestParam("catname") String categoryName,
				@RequestParam("catdesc") String categoryDesc,Model m)
		{
			Category category=categoryDAO.getCategory(categoryId);
			category.setCatname(categoryName);
			category.setCatdesc(categoryDesc);
			
			categoryDAO.updateCategory(category);
			
			List<Category> listCategories=categoryDAO.getCategories();
			m.addAttribute("listCategories",listCategories);
			
			return "Categorypage";
		}
	  
	  
	 	


}

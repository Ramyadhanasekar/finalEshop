package com.ecomm.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.ProductDAO;
import com.ecomm.model.Product;

public class ProductTest {
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(1);
		product.setSupId(1);
		product.setCatid(1);
		product.setPrice(1000);
		product.setStock(19);
		product.setProductName("candy");
		product.setProdDesc("Tasty and pluffy");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
	}
	
	
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(5));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(2);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
    
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(228);
		product.setPrice(456);
		product.setStock(0);
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
    @Ignore
	@Test
	public void listProductTest()
	{   
		List<Product> listProducts=productDAO.listProducts();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getStock()+":::");
			System.out.print(product.getPrice()+":::");
			System.out.println(product.getProdDesc());
		}
	}

	
	
	
	
}

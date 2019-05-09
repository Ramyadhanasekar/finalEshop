package com.ecomm.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.DAO.CategoryDAO;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.DAO.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController {
		@Autowired
		CategoryDAO categoryDAO;
		
		@Autowired
		ProductDAO productDAO;

		@Autowired
		SupplierDAO supplierDAO;
		
		@RequestMapping(value="/ProductDisplay")
		public String dispProduct(Model m) {
			List<Product> listProducts = productDAO.listProducts();
			m.addAttribute("listProducts", listProducts);

			return "ProductDisplay";
		}
		
		@RequestMapping(value="/ProdDesc/{productId}")
		public String productDescription(@PathVariable("productId") int proid,Model m) {
			Product product=productDAO.getProduct(proid);
			List<Product> listProducts = productDAO.listProducts();
			m.addAttribute("listProducts", listProducts);
			m.addAttribute("product",product);
		    return "ProdDesc";
		}
		
   @RequestMapping(value="/Productpage")
		public String displayProduct(Model m) {
			List<Product> listProducts = productDAO.listProducts();
			m.addAttribute("listProducts", listProducts);
			List<Category> listCategories=categoryDAO.getCategories();
			m.addAttribute("listCategories",listCategories);
			List<Supplier> listSuppliers = supplierDAO.getSuppliers();
			m.addAttribute("listSuppliers", listSuppliers);

			for (Product product : listProducts) {
				System.out.println(product.getProductName() + ",");
			}
			return "Productpage";
		}

		@RequestMapping(value = "/InsertProduct", method = RequestMethod.POST)
		public String addProduct(@RequestParam("productName") String productName, @RequestParam("prodDesc") String prodDesc,
				@RequestParam("price") int price,@RequestParam("stock") int stock,
				@RequestParam("categoryid") int catid,@RequestParam("supplierid") int supid,@RequestParam("pimage") MultipartFile pimage,Model m) {
			Product product=new Product();
			product.setProductName(productName);
			product.setProdDesc(prodDesc);
			product.setPrice(price);
			product.setStock(stock);
			product.setCatid(catid);
			product.setSupId(supid);
			
			productDAO.addProduct(product);
			 
			 String path="F:/mavenprojectworkspace/Eshopfrontend/src/main/webapp/resources/images/";
				
			 path=path+String.valueOf(product.getProductId())+".jpg";
			    
		     File image=new File(path);
				
				if(!pimage.isEmpty())
				{

					try {
						byte[] buffer=pimage.getBytes();	
						FileOutputStream fos=new FileOutputStream(image);
						BufferedOutputStream bs=new BufferedOutputStream(fos);
						bs.write(buffer);
						bs.close();

					}
					
					catch (Exception e)
					{
						System.out.println("Exception Arised:"+e);
						e.printStackTrace();
					}
					
				}
				else
				{
					System.out.println("Problem Occured in File Uploading");
				}
			 
			 List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("listProducts", listProducts);
				List<Category> listCategories=categoryDAO.getCategories();
				m.addAttribute("listCategories",listCategories);
				List<Supplier> listSuppliers = supplierDAO.getSuppliers();
				m.addAttribute("listSuppliers", listSuppliers);

				return "Productpage";
			}

			@RequestMapping(value="/deleteProduct/{productId}")
			public String deleteProduct(@PathVariable("productId") int productId,Model m)
			{
				Product product=productDAO.getProduct(productId);
				
				String path="F:/mavenprojectworkspace/Eshopfrontend/src/main/webapp/resources/images/";
				path=path+String.valueOf(product.getProductId())+".jpg";
			    File image=new File(path);
				image.delete();
				
				productDAO.deleteProduct(product);
				
				List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("listProducts", listProducts);
				List<Category> listCategories=categoryDAO.getCategories();
				m.addAttribute("listCategories",listCategories);
				List<Supplier> listSuppliers = supplierDAO.getSuppliers();
				m.addAttribute("listSuppliers", listSuppliers);
				return "Productpage";
			}

			@RequestMapping(value="/updateProduct/{productId}")
			public String updateCategory(@PathVariable("productId") int productId,Model m)
			{
				Product product=productDAO.getProduct(productId);
				
				
				List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("listProducts", listProducts);
				List<Category> listCategories=categoryDAO.getCategories();
				m.addAttribute("listCategories",listCategories);
				List<Supplier> listSuppliers = supplierDAO.getSuppliers();
				m.addAttribute("listSuppliers", listSuppliers);
				m.addAttribute("product",product);
				
				return "updateProduct";
			}
		
			@RequestMapping(value="/updateProductDB/{productId}",method=RequestMethod.POST)
			public String updateProductDatabase(@PathVariable("productId") int productId,@RequestParam("productName") String productName,
					@RequestParam("prodDesc") String prodDesc,@RequestParam("price") int price,@RequestParam("stock") int stock,
					@RequestParam("categoryid") int catid,@RequestParam("supplierid") int supId,@RequestParam("pimage") MultipartFile pimage,Model m)
			{
				Product product=productDAO.getProduct(productId);
				product.setProductName(productName);
				product.setProdDesc(prodDesc);
				product.setPrice(price);
				product.setStock(stock);
				product.setCatid(catid);
				product.setSupId(supId);
				
				if(!pimage.isEmpty())
				{
					String path="F:/mavenprojectworkspace/Eshopfrontend/src/main/webapp/resources/images/";
					path=path+String.valueOf(product.getProductId())+".jpg";
				    File oldimage=new File(path);
					oldimage.delete();

					File image=new File(path);
					try {
						byte[] buffer=pimage.getBytes();	
						FileOutputStream fos=new FileOutputStream(image);
						BufferedOutputStream bs=new BufferedOutputStream(fos);
						bs.write(buffer);
						bs.close();

					}
					
					catch (Exception e)
					{
						System.out.println("Exception Arised:"+e);
						e.printStackTrace();
					}
					
				}
				
				
				productDAO.updateProduct(product);
				
			
				//Category category=categoryDAO.getCategory(catid);
				//Supplier supplier=supplierDAO.getSupplier(supId);
				
				List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("listProducts", listProducts);
				List<Category> listCategories=categoryDAO.getCategories();
				m.addAttribute("listCategories",listCategories);
				List<Supplier> listSuppliers = supplierDAO.getSuppliers();
				m.addAttribute("listSuppliers", listSuppliers);
				
				
				return "Productpage";
			}
		
		
		
		
		
		
}
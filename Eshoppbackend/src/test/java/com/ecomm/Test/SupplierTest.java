package com.ecomm.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.SupplierDAO;
import com.ecomm.model.Supplier;
@Transactional
public class SupplierTest {
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	
	@Test
	public void addSupplierTest()
	{
		System.out.println("Supplier Added");
		Supplier supplier=new Supplier();
		supplier.setSupName("rekha");
		supplier.setSupLocation("Banglore");
	    assertTrue("Problem in Supplier Insertion",supplierDAO.addSupplier(supplier));
	}
	
	
	
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> listSuppliers=supplierDAO.getSuppliers();
		assertNotNull("No Suppliers",listSuppliers);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.println(supplier.getSupId()+":::");
			System.out.println(supplier.getSupName()+":::");
			System.out.println(supplier.getSupLocation());
		}
	}
	
	
	/*@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get Supplier",supplierDAO.getSupplier(2));
	}*/
/*
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(46);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}*/
	
	
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(12);
	    supplier.setSupId(5);
		supplier.setSupName("Faster");
		assertTrue("Problem in Updation",supplierDAO.updateSuppplier(supplier));
	}
	
	
	
	
}
	
	
	
	
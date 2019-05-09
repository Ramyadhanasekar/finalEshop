package com.ecomm.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.DAO.SupplierDAO;
import com.ecomm.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;
	
	

	@RequestMapping(value="/Supplierpage", method = RequestMethod.GET)
	public String showSupplier(Model m)
	{
		
		List<Supplier> listSupplier = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSupplier);

		for (Supplier supplier : listSupplier)
		{
			System.out.println(supplier.getSupName() + ",");
			System.out.println(supplier.getSupLocation()+ ",");
			System.out.println(supplier.getSupId()+ ",");
		}
		
		return "Supplierpage";
		
	}
	
	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplierData(@RequestParam("supName") String supName, @RequestParam("supLocation") String supLocation,Model m) 
	{
		Supplier supplier = new Supplier();
		supplier.setSupName(supName);
		supplier.setSupLocation(supLocation);

		supplierDAO.addSupplier(supplier);

		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		
		return "Supplierpage";
	}

	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",listSuppliers);
		
		return "Supplierpage";
	}

	@RequestMapping("/updateSupplier/{supId}")
	public String updateSupplier(@PathVariable("supId") int supId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supId);
		
		
		List<Supplier> listSupplier=supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",listSupplier);
		m.addAttribute("SupplierInfo",supplier);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateCategoryInDB(@RequestParam("supid") int supplierId,@RequestParam("supname") String supplierName,
			@RequestParam("suplocation") String supplierLocation,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplier.setSupName(supplierName);
		supplier.setSupLocation(supplierLocation);
		
		supplierDAO.updateSuppplier(supplier);
		
		List<Supplier> listSup=supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",listSup);
		
		return "Supplierpage";
	}


	
	}
	
	
	
	
	
	
	
	


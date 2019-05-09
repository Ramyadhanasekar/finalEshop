package com.ecomm.DAO;



import java.util.List;

import com.ecomm.model.Supplier;

public interface SupplierDAO
{
	

public boolean addSupplier(Supplier supplier);
public Supplier getSupplier(int supplierId);
public boolean deleteSupplier(Supplier supplier);
public boolean updateSuppplier(Supplier supplier);
public List<Supplier> getSuppliers();



}

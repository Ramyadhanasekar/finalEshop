package com.ecomm.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Supplier;


	
@Repository("supplierDAO")
	public class SupplierDAOImpl implements SupplierDAO
	{
		
			@Autowired
			SessionFactory sessionFactory;
			
			@Transactional
		   
		@Override
		public boolean addSupplier(Supplier supplier) {
			try
			{
			sessionFactory.getCurrentSession().save(supplier);
		    System.out.println("Supplier Data Added");
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception Arised:"+e);
			return false;
		}

			
	}
			@Override
			public List<Supplier> getSuppliers() {
				Session session=sessionFactory.openSession();
				Query query=session.createQuery("from Supplier");
				List<Supplier> listSuppliers=(List<Supplier>)query.list();
				return listSuppliers;
				
			}

			@Override
			public Supplier getSupplier(int supplierId) {
				Session session=sessionFactory.openSession();
				Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
				session.close();
				return supplier;				
			}
			@Transactional
			@Override
			public boolean deleteSupplier(Supplier supplier) {
				try
				{
					sessionFactory.getCurrentSession().delete(supplier);
					return true;
				}
				catch(Exception e)
				{
					System.out.println("Exception Arised:"+e);
					return false;
				}
				
			}
           @Transactional
			@Override
			public boolean updateSuppplier(Supplier supplier) {
				try
				{
					sessionFactory.getCurrentSession().update(supplier);
					
					return true;
				}
				catch(Exception e)
				{
					System.out.println("Exception Arised:"+e);
					return false;
				}
			}
				
	}


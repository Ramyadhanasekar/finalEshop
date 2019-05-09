package com.ecomm.Test.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.DAO.CartItemDAO;
import com.ecomm.DAO.CartItemDAOImpl;
import com.ecomm.DAO.CategoryDAO;
import com.ecomm.DAO.CategoryDAOImpl;
import com.ecomm.DAO.OrderDetailDAO;
import com.ecomm.DAO.OrderDetailDAOImpl;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.DAO.ProductDAOImpl;
import com.ecomm.DAO.SupplierDAO;
import com.ecomm.DAO.SupplierDAOImpl;
import com.ecomm.DAO.UserDAO;
import com.ecomm.DAO.UserDAOImpl;
import com.ecomm.model.CartItem;
import com.ecomm.model.Category;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.User;


@Configuration
	@ComponentScan("com.ecomm")
	@EnableTransactionManagement
	public class DBconfig 
	{
		@Autowired
		@Bean (name="dataSource")
		public DataSource getH2DataSource()
		{
			System.out.println("Data Source Object Creating");
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/mydb");
			dataSource.setUsername("ramya");
			dataSource.setPassword("ramya");
			System.out.println("Data Source Object Created");
			return dataSource;
		}
		
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory() 
		{
			System.out.println("Hibernate Properties Object Creating");
			Properties properties = new Properties();
			properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			properties.put("hibernate.hbm2ddl.auto","update");
			System.out.println("Hibernate Properties Object Created");
			System.out.println("Table Source Created");
			System.out.println("Session Factory Object Creating");
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
			sessionBuilder.addProperties(properties);
			sessionBuilder.addAnnotatedClass(Category.class);
			sessionBuilder.addAnnotatedClass(Supplier.class);
			sessionBuilder.addAnnotatedClass(Product.class);
			sessionBuilder.addAnnotatedClass(CartItem.class);
			sessionBuilder.addAnnotatedClass(User.class);
			sessionBuilder.addAnnotatedClass(OrderDetail.class);
			
			
			System.out.println("Session Factory Object Created");
			return sessionBuilder.buildSessionFactory();
		}	
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
		{
			System.out.println("Transaction Manager Object Creating");
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			System.out.println("Transaction Manager Object Created");
			return transactionManager;
		}
		
		@Bean(name="categoryDAO")
		public CategoryDAO getCategoryDAO()
		{
		System.out.println(">>>>>>>>>>>>>>.......Category dao created>>>>>>>>>>>>>>>>>>>>>>");
		return new CategoryDAOImpl();
		}
		
		@Bean(name="supplierDAO")
		public SupplierDAO getSupplierDAO()
		{
			System.out.println("----Supplier DAO Implementation---");
			return new SupplierDAOImpl();
		}
		@Bean(name="ProductDAO")
		public ProductDAO getProductDAO()
		{
			System.out.println("----Product DAO Implementation---");
			return new ProductDAOImpl();
		}
		
		@Bean(name="cartItemDAO")
		public CartItemDAO getCartItemDAO()
		{
			System.out.println("----Cart DAO Implementation---");
			return new CartItemDAOImpl();
		}
		@Bean(name="userDAO") 
		  public UserDAO getUserDAO() {
			
		  	System.out.println("User DAO Implementation");
		  	return new UserDAOImpl();
		 
	}
		@Bean(name="orderDetailDAO") 
		  public OrderDetailDAO getOrderDetailDAO() {
			
		  	System.out.println("OrderDetail DAO Implementation");
		  	return new OrderDetailDAOImpl();
		
		
}}

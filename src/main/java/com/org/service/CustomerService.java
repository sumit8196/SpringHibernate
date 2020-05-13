package com.org.service;

import java.util.List;
import java.util.TreeMap;
import javax.transaction.Transactional;
import org.hibernate.criterion.Disjunction;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.DAO.CustomerDAO;
import com.org.entity.Customer;

@Service
public class CustomerService implements ICustomerSercvice {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired 
	private CustomerDAO customerDAO;
	 
	 @Transactional  
	public List<Customer> list() {
		 log.info("Entry at: CustomerService->list" );
		 List<Customer> list=null;
		 TreeMap<String, Customer>map=new TreeMap<String, Customer>();
		 try {
			  list=customerDAO.list();
			  //list.sort((Customer c1, Customer c2)->c1.getFirstName().compareTo(c2.getFirstName())); 

			 // map=list.stream().collect(Collectors.toMap(Customer::getFirstName, Customer::this));
		 }catch(Exception ex) {
			 log.error("Exceptoin has occured at"+ex);
		 }
		
		 log.debug("Exit at: CustomerService->list" );
		return list;
	}
	 
	@Transactional
	public boolean add(Customer customer) {
		 log.info("Entry at: CustomerService->add" );
		 Customer cust=null;
		 boolean isSuccess=false;
		 try {
			customerDAO.add(customer);
			isSuccess=true;
		 }catch(Exception ex) {
			 log.error("Error has occured",ex);
		 }
		 log.debug("Exit at: CustomerService->add" );
		return isSuccess;
	}
	@Transactional
	public Customer findNow(int id) {
		log.info("Entry at: CustomerService->findNow" );
		Customer customer=null;
		try {
			customer=customerDAO.findNow(id);
		}catch(Exception ex) {
			log.error("Error has occured",ex);
		}
		log.debug("Exit at: CustomerService->findNow" );
		return customer;
	}

	@Transactional
	public void deleteNow(int id) {
		log.info("Entry at: CustomerService->deleteNow" );
		try {
			customerDAO.delete(id);
		}catch(Exception ex) {
			log.error("Error has occured deleteNow",ex);
		}
		log.debug("Exit at: CustomerService->deleteNow" );
		
	}

	@Transactional
	public List<Customer> search(String searchParams) {
		log.info("Entry at: CustomerService->search" );
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		Disjunction disjunction=Restrictions.disjunction();
		List<Customer> customers=null;
		try {
			disjunction.add(Restrictions.like("firstName","%"+searchParams+"%"));
			 disjunction.add(Restrictions.like("lastName","%"+searchParams+"%"));
			 disjunction.add(Restrictions.like("email","%"+searchParams+"%"));
			  criteria.add(disjunction);
			customers=customerDAO.search(criteria);
		}catch(Exception ex) {
			log.error("Error has occured search",ex);
		}
		log.debug("Exit at: CustomerService->search" );
		return customers;
	}
	 
	

}

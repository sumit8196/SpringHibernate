package com.org.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.entity.Customer;

@Repository
public class CustomerDAO implements ICustotmerDAO {
 
	@Autowired
	private SessionFactory sessionFactory; 	 
    
	public List<Customer> list() {
    	//Get the current session
    	
    	 Session currentSession= sessionFactory.getCurrentSession();
    	 	//Create Query
    	 Query<Customer> query=currentSession.createQuery("from Customer order by firstName",Customer.class) ;
     	 List<Customer> customers= query.getResultList();
    	 
		return customers;
	}


	public void add(Customer customer) {
		//Get the current session
		Session currentSession= sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}


	public Customer findNow(int id) {
		Session currentSession= sessionFactory.getCurrentSession();
		  Customer customer=currentSession.get(Customer.class, id);
		// TODO Auto-generated method stub
		return customer;
	}


	public void delete(int id) {
		Session currentSession= sessionFactory.getCurrentSession();
		Query query=currentSession.createQuery("delete from Customer where id=:id");
		  query.setParameter("id",id);
		 query.executeUpdate();	
		// currentSession.delete(id); 
	}


	public List<Customer> search(DetachedCriteria criteria) {
		List<Customer> customers=null;
		Session currentSession= sessionFactory.getCurrentSession();
		customers=criteria.getExecutableCriteria(currentSession).list();
		return customers;
	}

}

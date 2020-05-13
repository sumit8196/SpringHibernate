package com.org.DAO;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.org.entity.Customer;
public interface ICustotmerDAO {
	
    public List<Customer> list();
    public void add(Customer customer);
    public Customer findNow(int id);
    public void delete(int id);
    public List<Customer> search(DetachedCriteria criteria);
}

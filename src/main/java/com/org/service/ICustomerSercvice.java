package com.org.service;

import java.util.List;

import com.org.entity.Customer;

public interface ICustomerSercvice {
  public List<Customer> list();
  public boolean add(Customer customer);
  public Customer findNow(int id);
  public void deleteNow(int id);
  public List<Customer> search(String searchParams);
}

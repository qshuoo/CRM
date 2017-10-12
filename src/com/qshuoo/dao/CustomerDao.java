package com.qshuoo.dao;

import java.util.List;

import org.hibernate.Session;

import com.qshuoo.pojo.Customer;

public interface CustomerDao {

	public void insertCustomer(Customer customer);

	public Long getCustomerCount();

	public List<Customer> getCustomersByPage(int current_page, int page_size);

	public void deleteCustomerById(Long id);
	
	public Customer getCustomerById(Long id);


}

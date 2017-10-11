package com.qshuoo.dao;

import java.util.List;

import org.hibernate.Session;

import com.qshuoo.pojo.Customer;

public interface CustomerDao {

	public void insertCustomer(Customer customer);

	public long getCustomerCount();

	public List<Customer> getCustomersByPage(int current_page, int page_size);


}

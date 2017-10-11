package com.qshuoo.service;

import java.util.List;

import com.qshuoo.exception.CustomerException;
import com.qshuoo.pojo.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer) throws CustomerException;

	public long getCustomerCount() throws CustomerException;

	public long getTotalPages(long totalNums, int pageSize);

	public List<Customer> getCustomersByPage(int current_page, int page_size) throws CustomerException;

}

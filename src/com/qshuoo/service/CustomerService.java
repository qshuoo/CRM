package com.qshuoo.service;

import com.qshuoo.exception.CustomerException;
import com.qshuoo.pojo.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer) throws CustomerException;

}

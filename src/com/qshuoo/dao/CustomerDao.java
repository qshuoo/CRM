package com.qshuoo.dao;

import org.hibernate.Session;

import com.qshuoo.pojo.Customer;

public interface CustomerDao {

	public void insertCustomer(Customer customer, Session session);

}

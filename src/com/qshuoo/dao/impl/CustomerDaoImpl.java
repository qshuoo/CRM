package com.qshuoo.dao.impl;

import org.hibernate.Session;

import com.qshuoo.dao.CustomerDao;
import com.qshuoo.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void insertCustomer(Customer customer, Session session) {
		session.save(customer);
	}

}

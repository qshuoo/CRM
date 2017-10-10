package com.qshuoo.service.impl;

import org.hibernate.Session;

import com.qshuoo.dao.CustomerDao;
import com.qshuoo.dao.impl.CustomerDaoImpl;
import com.qshuoo.exception.CustomerException;
import com.qshuoo.pojo.Customer;
import com.qshuoo.service.CustomerService;
import com.qshuoo.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao cd = new CustomerDaoImpl();
	@Override
	public void addCustomer(Customer customer) throws CustomerException{
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		try {
			cd.insertCustomer(customer, session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new CustomerException();
		} finally {
			session.close();
		}
	}

}

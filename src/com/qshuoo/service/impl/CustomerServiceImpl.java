package com.qshuoo.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qshuoo.dao.CustomerDao;
import com.qshuoo.dao.impl.CustomerDaoImpl;
import com.qshuoo.exception.CustomerException;
import com.qshuoo.pojo.Customer;
import com.qshuoo.service.CustomerService;
import com.qshuoo.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao cd = new CustomerDaoImpl();

	@Override
	public void addCustomer(Customer customer) throws CustomerException {
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		try {
			cd.insertCustomer(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new CustomerException();
		}
	}

	@Override
	public Long getCustomerCount() throws CustomerException {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Long count = null;
		try {
			count = cd.getCustomerCount();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomerException();
		}
		return count;
	}

	@Override
	public Long getTotalPages(Long totalNums, int pageSize) {
		return totalNums / pageSize + (totalNums % pageSize == 0 ? 0 : 1);
	}

	@Override
	public List<Customer> getCustomersByPage(int current_page, int page_size) throws CustomerException {
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		List<Customer> customers = null;
		try {
			customers = cd.getCustomersByPage(current_page, page_size);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new CustomerException(e.getMessage());
		}

		return customers;
	}

	@Override
	public void deleteCustomerById(Long id) throws CustomerException {
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		try {
			cd.deleteCustomerById(id);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new CustomerException(e.getMessage());
		}
	}

}

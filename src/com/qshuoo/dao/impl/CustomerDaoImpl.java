package com.qshuoo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.qshuoo.dao.CustomerDao;
import com.qshuoo.pojo.Customer;
import com.qshuoo.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void insertCustomer(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(customer);
	}

	@Override
	public long getCustomerCount() {
		Session session = HibernateUtils.getCurrentSession();
		Query<Long> query = session.createQuery("select count(*) from Customer", Long.class);
		long count = query.uniqueResult();
		return count;
	}

	@Override
	public List<Customer> getCustomersByPage(int current_page, int page_size) {
		Session session = HibernateUtils.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		query.setFirstResult((current_page - 1) * page_size);
		query.setMaxResults(page_size);
		return query.list();
	}

}

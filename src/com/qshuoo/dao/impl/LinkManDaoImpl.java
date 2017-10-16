package com.qshuoo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.qshuoo.dao.LinkManDao;
import com.qshuoo.pojo.Customer;
import com.qshuoo.pojo.LinkMan;
import com.qshuoo.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void insertLinkMan(LinkMan linkMan, Customer customer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		linkMan.setCustomer(customer);
		customer.getLinkmen().add(linkMan);
		session.save(customer);
		
	}

	@Override
	public Long getLinkManCount() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		String hql = "select count(*) from LinkMan";
		Query<Long> query = session.createQuery(hql ,Long.class);
		return query.uniqueResult();
	}

	@Override
	public List<LinkMan> getCustomersByPage(int current_page, int page_size) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		String hql = "from LinkMan";
		Query<LinkMan> query = session.createQuery(hql,LinkMan.class);
		query.setFirstResult((current_page - 1) * page_size);
		query.setMaxResults(page_size);
		return query.list();
	}

}

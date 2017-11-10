package com.qshuoo.service.impl;

import java.util.List;

import org.hibernate.Session;

import com.qshuoo.dao.CustomerDao;
import com.qshuoo.dao.LinkManDao;
import com.qshuoo.dao.impl.CustomerDaoImpl;
import com.qshuoo.dao.impl.LinkManDaoImpl;
import com.qshuoo.exception.LinkManException;
import com.qshuoo.pojo.Customer;
import com.qshuoo.pojo.LinkMan;
import com.qshuoo.service.LinkManService;
import com.qshuoo.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {

	CustomerDao cd = new CustomerDaoImpl();
	LinkManDao ld = new LinkManDaoImpl();

	@Override
	public void addLinkMan(LinkMan linkMan) throws LinkManException {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		try {
			Customer customer = cd.getCustomerById(linkMan.getLinkman_cust_id());
			ld.insertLinkMan(linkMan, customer);
			// System.out.println("+++"+session.get(LinkMan.class,
			// linkMan.getLinkman_id()));
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			throw new LinkManException();
		}

	}

	@Override
	public Long getLinkManCount() throws LinkManException {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Long linkman_num = null;
		try {
			session.beginTransaction();
			linkman_num = ld.getLinkManCount();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			throw new LinkManException();
		}

		return linkman_num;
	}

	@Override
	public Long getTotalPages(Long linkman_nums, int page_size) {
		// TODO Auto-generated method stub
		return linkman_nums / page_size + (linkman_nums % page_size == 0 ? 0 : 1);
	}

	@Override
	public List<LinkMan> getCustomersByPage(int current_page, int page_size) throws LinkManException {
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		List<LinkMan> linkmen = null;
		try {
			linkmen = ld.getCustomersByPage(current_page, page_size);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new LinkManException(e.getMessage());
		}

		return linkmen;
	}

}

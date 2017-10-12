package com.qshuoo.service.impl;

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
	public void addLinkMan(LinkMan linkMan) throws LinkManException{
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession(); 
		session.beginTransaction();
		try {
			Customer customer = cd.getCustomerById(linkMan.getLinkman_cust_id());
			linkMan.setCustomer(customer);
			ld.insert(linkMan);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			throw new LinkManException();
		}
		
	}

}

package com.qshuoo.dao.impl;

import org.hibernate.Session;

import com.qshuoo.dao.LinkManDao;
import com.qshuoo.pojo.LinkMan;
import com.qshuoo.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void insert(LinkMan linkMan) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		session.save(linkMan);
	}

}

package com.qshuoo.test;

import org.hibernate.Session;
import org.junit.Test;

import com.qshuoo.pojo.Customer;
import com.qshuoo.pojo.LinkMan;
import com.qshuoo.utils.HibernateUtils;

public class Test01 {

	@Test
	public void test01() {
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		Customer customer = session.get(Customer.class, Long.valueOf(1));
		LinkMan linkMan = session.get(LinkMan.class, Long.valueOf(1));
		System.out.println(customer.getLinkmen());
		System.out.println(linkMan.getCustomer());
		session.getTransaction().commit();
	}
}

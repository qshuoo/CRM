package com.qshuoo.dao;

import java.util.List;

import com.qshuoo.pojo.Customer;
import com.qshuoo.pojo.LinkMan;

public interface LinkManDao {

	public void insertLinkMan(LinkMan linkMan, Customer customer);

	public Long getLinkManCount();

	public List<LinkMan> getCustomersByPage(int current_page, int page_size);

}

package com.qshuoo.dao;

import java.util.List;

import com.qshuoo.pojo.Customer;
import com.qshuoo.pojo.LinkMan;

public interface LinkManDao {

	/**
	 * 插入联系人
	 * @param linkMan
	 * @param customer
	 */
	public void insertLinkMan(LinkMan linkMan, Customer customer);

	/**
	 * 得到联系人数量
	 * @return
	 */
	public Long getLinkManCount();

	/**
	 * 分页查询联系人
	 * @param current_page
	 * @param page_size
	 * @return
	 */
	public List<LinkMan> getCustomersByPage(int current_page, int page_size);

}

package com.qshuoo.dao;

import java.util.List;


import com.qshuoo.pojo.Customer;

public interface CustomerDao {

	/**
	 * 插入顾客
	 * @param customer
	 */
	public void insertCustomer(Customer customer);

	/**
	 * 得到顾客数量
	 * @return
	 */
	public Long getCustomerCount();

	/**
	 * 分页查询客户
	 * @param current_page
	 * @param page_size
	 * @return
	 */
	public List<Customer> getCustomersByPage(int current_page, int page_size);

	/**
	 * 通过id删除客户
	 * @param id
	 */
	public void deleteCustomerById(Long id);
	
	/**
	 * 通过id获取客户
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(Long id);


}

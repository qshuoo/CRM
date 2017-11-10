package com.qshuoo.service;

import java.util.List;

import com.qshuoo.exception.CustomerException;
import com.qshuoo.pojo.Customer;

public interface CustomerService {

	/**
	 * 添加客户
	 * @param customer
	 * @throws CustomerException
	 */
	public void addCustomer(Customer customer) throws CustomerException;

	/**
	 * 得到顾客数量
	 * @return
	 * @throws CustomerException
	 */
	public Long getCustomerCount() throws CustomerException;

	/**
	 * 得到总页数
	 * @param totalNums
	 * @param pageSize
	 * @return
	 */
	public Long getTotalPages(Long totalNums, int pageSize);

	/**
	 * 展示顾客
	 * @param current_page
	 * @param page_size
	 * @return
	 * @throws CustomerException
	 */
	public List<Customer> getCustomersByPage(int current_page, int page_size) throws CustomerException;

	/**
	 * 通过删除用户
	 * @param Long1
	 * @throws CustomerException
	 */
	public void deleteCustomerById(Long Long1) throws CustomerException;

}

package com.qshuoo.service;

import java.util.List;

import com.qshuoo.exception.LinkManException;
import com.qshuoo.pojo.LinkMan;

public interface LinkManService {

	/**
	 * 添加联系人
	 * @param linkMan
	 * @throws LinkManException
	 */
	public void addLinkMan(LinkMan linkMan) throws LinkManException;

	/**
	 * 得到联系人的数量
	 * @return
	 * @throws LinkManException
	 */
	public Long getLinkManCount() throws LinkManException;

	/**
	 * 得到页数
	 * @param linkman_nums
	 * @param page_size
	 * @return
	 */
	public Long getTotalPages(Long linkman_nums, int page_size);

	/**
	 * 展示联系人
	 * @param current_page
	 * @param page_size
	 * @return
	 * @throws LinkManException
	 */
	public List<LinkMan> getCustomersByPage(int current_page, int page_size) throws LinkManException;


}

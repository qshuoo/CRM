package com.qshuoo.service;

import java.util.List;

import com.qshuoo.exception.LinkManException;
import com.qshuoo.pojo.Customer;
import com.qshuoo.pojo.LinkMan;

public interface LinkManService {

	public void addLinkMan(LinkMan linkMan) throws LinkManException;

	public Long getLinkManCount() throws LinkManException;

	public Long getTotalPages(Long linkman_nums, int page_size);

	public List<LinkMan> getCustomersByPage(int current_page, int page_size) throws LinkManException;


}

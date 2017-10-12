package com.qshuoo.service;

import com.qshuoo.exception.LinkManException;
import com.qshuoo.pojo.LinkMan;

public interface LinkManService {

	public void addLinkMan(LinkMan linkMan) throws LinkManException;

}

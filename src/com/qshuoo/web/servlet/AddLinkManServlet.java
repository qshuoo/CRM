package com.qshuoo.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qshuoo.exception.LinkManException;
import com.qshuoo.pojo.LinkMan;
import com.qshuoo.service.LinkManService;
import com.qshuoo.service.impl.LinkManServiceImpl;

@WebServlet("/AddLinkManServlet")
public class AddLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddLinkManServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LinkMan linkMan = new LinkMan();
		LinkManService ls = new LinkManServiceImpl();
		try {
			BeanUtils.populate(linkMan, request.getParameterMap());
			ls.addLinkMan(linkMan);
			response.sendRedirect("GetLinkManCountServlet");
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("<script>");
			response.getWriter().write("alert('上传信息失败');");
			response.getWriter().write("location.href='jsp/linkman/add.jsp'");
			response.getWriter().write("</script>");
		} catch (LinkManException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("<script>");
			response.getWriter().write("alert('添加失败');");
			response.getWriter().write("location.href='jsp/linkman/add.jsp'");
			response.getWriter().write("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

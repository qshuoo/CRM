package com.qshuoo.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qshuoo.exception.CustomerException;
import com.qshuoo.service.CustomerService;
import com.qshuoo.service.impl.CustomerServiceImpl;

@WebServlet("/GetCustomerCountServlet")
public class GetCustomerCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetCustomerCountServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService cs = new CustomerServiceImpl();
		try {
			Long cust_nums = cs.getCustomerCount();
			Long total_pages = cs.getTotalPages(cust_nums, 4);
			HttpSession session = request.getSession();
			session.setAttribute("cust_nums", cust_nums);
			session.setAttribute("total_pages", total_pages);
			request.setAttribute("page", 1);
			request.getRequestDispatcher("GetCustomerByPageServlet").forward(request, response);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("<script>");
			response.getWriter().write("alert('跳转失败');");
			response.getWriter().write("location.href='index.jsp';");
			response.getWriter().write("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

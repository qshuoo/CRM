package com.qshuoo.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qshuoo.exception.CustomerException;
import com.qshuoo.pojo.Customer;
import com.qshuoo.service.CustomerService;
import com.qshuoo.service.impl.CustomerServiceImpl;

@WebServlet("/GetCustomerByPageServlet")
public class GetCustomerByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetCustomerByPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		int current_page = 0;
		if (page == null) {
			current_page = (int) request.getAttribute("page");
		} else {
			current_page = Integer.parseInt(page);
		}

		int page_size = 4;
		CustomerService cs = new CustomerServiceImpl();
		try {
			List<Customer> customers = cs.getCustomersByPage(current_page, page_size);
			HttpSession session = request.getSession();
			session.setAttribute("current_page", current_page);
			session.setAttribute("list", customers);
			response.sendRedirect("jsp/customer/list.jsp");
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("<script>");
			response.getWriter().write("alert('获取用户列表失败');");
			response.getWriter().write("location.href='welcome.jsp';");
			response.getWriter().write("</script>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

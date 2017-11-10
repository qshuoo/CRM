package com.qshuoo.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qshuoo.exception.CustomerException;
import com.qshuoo.service.CustomerService;
import com.qshuoo.service.impl.CustomerServiceImpl;

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService cs = new CustomerServiceImpl();
		String cust_id = request.getParameter("cust_id");
		try {
			cs.deleteCustomerById(Long.valueOf(cust_id));
			request.getRequestDispatcher("GetCustomerCountServlet").forward(request, response);
		} catch (NumberFormatException | CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			response.getWriter().write("<script>");
			response.getWriter().write("alert('删除失败');");
			response.getWriter().write("location.href='jsp/customer/list.jsp';");
			response.getWriter().write("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

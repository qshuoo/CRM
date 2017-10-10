package com.qshuoo.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qshuoo.exception.CustomerException;
import com.qshuoo.pojo.Customer;
import com.qshuoo.service.CustomerService;
import com.qshuoo.service.impl.CustomerServiceImpl;

@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		CustomerService cs = new CustomerServiceImpl();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
			cs.addCustomer(customer);
			response.sendRedirect("jsp/customer/list.jsp");
		} catch (IllegalAccessException | InvocationTargetException e) {
			//e.printStackTrace();
			response.getWriter().write("<script>");
			response.getWriter().write("alert('上传失败');");
			response.getWriter().write("location.href='jsp/customer/add.jsp';");
			response.getWriter().write("</script>");
		} catch (CustomerException e) {
			//e.printStackTrace();
			response.getWriter().write("<script>");
			response.getWriter().write("alert('添加失败');");
			response.getWriter().write("location.href='jsp/customer/add.jsp';");
			response.getWriter().write("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.qshuoo.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qshuoo.exception.LinkManException;
import com.qshuoo.service.LinkManService;
import com.qshuoo.service.impl.LinkManServiceImpl;

/**
 * Servlet implementation class GetLinkManCountServlet
 */
@WebServlet("/GetLinkManCountServlet")
public class GetLinkManCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetLinkManCountServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LinkManService ls = new LinkManServiceImpl();
		try {
			Long linkman_nums = ls.getLinkManCount();
			Long total_pages = ls.getTotalPages(linkman_nums, 4);
			HttpSession session = request.getSession();
			session.setAttribute("linkman_nums", linkman_nums);
			session.setAttribute("total_pages", total_pages);
			request.setAttribute("page", 1);
			request.getRequestDispatcher("GetLinkManByPageServlet").forward(request, response);

		} catch (LinkManException e) {
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

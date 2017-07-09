package com.full.servlet;
import java.io.IOException;

//import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.full.model.User;
@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/home".equals(req.getRequestURI())) {
			goToLoginHtml(req, resp);
		} else if ("/main".equals(req.getRequestURI())) {
			welcomeUser(req, resp);
		}
	}
	private void welcomeUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		System.out.println();
		if (session == null || session.getAttribute("user") == null) {
			req.getRequestDispatcher("/home").forward(req, resp);
		} else {
			User user=(User) session.getAttribute("user");
			resp.getWriter().println("<span> Welcome "+user.getGiven_name()+"</span>"+"<img align='right' style='border-radius:50px' width='50px' height='50px' src='"+user.getPicture()+"'></img>");
			req.getRequestDispatcher("/WEB-INF/html/main.html").forward(req, resp);
		}
	}
	private void goToLoginHtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/").forward(req, resp);
	}

	
}

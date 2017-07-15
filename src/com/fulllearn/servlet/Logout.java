package com.fulllearn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Logout extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 if ("/logout".equals(req.getRequestURI())) {
			sessionInValidate(req, resp);
		}
	}

	private void sessionInValidate(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("user") != null) {
			session.invalidate();
			req.getRequestDispatcher("/WEB-INF/html/login.html").forward(req, resp);
		} 
	}

	
}

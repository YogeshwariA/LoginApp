package com.full.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if ("post".equalsIgnoreCase(method)) {
			doPost(req, resp);
		} else if ("get".equalsIgnoreCase(method)) {
			doGet(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/logoutconfirm".equals(req.getRequestURI())) {
			goToLogoutHtml(req, resp);

		} else if ("/logout".equals(req.getRequestURI())) {
			sessionInValidate(req, resp);
		}

	}

	private void goToLogoutHtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/html/logout_confirmation.html").forward(req, resp);
	}

	private void sessionInValidate(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("user") != null) {
			session.invalidate();
			resp.getWriter().println("Successfully logout.");

			req.getRequestDispatcher("/WEB-INF/html/logout.html").forward(req, resp);

		} else {
			req.getRequestDispatcher("/home").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/home");
	}
}

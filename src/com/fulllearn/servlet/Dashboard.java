package com.fulllearn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fulllearn.model.User;

@SuppressWarnings("serial")
public class Dashboard extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			welcomeUser(req, resp);
		
	}

	private void welcomeUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		System.out.println();
		if (session == null || session.getAttribute("user") == null) {
			req.getRequestDispatcher("WEB-INf/html/login.html").forward(req, resp);
		} else {
			User user = (User) session.getAttribute("user");
			System.out.println(user.getFirstName());
			resp.setContentType("text/html");
			String responseString = "<div id='welcomeDiv' class='card' style='top:50px;margin-left: 500px; height: 200px; width: 300px;'>"
					+ "<div class='card-header' style='color: white; background-color: darkcyan;'>Welcome !!!</div>"
					+ "<div class='card-block'>" + "<span id='usernameSpan'>" + user.getFirstName() + "</div>"
					+ user.getLastName() + " </span><img align='right' id='profilePic'"
					+ "style='border-radius:50px' width='50px' height='50px' src='" + user.getPhotoId() + " '></img>"
					+ "<a align='right' class='link' style='text-align:right' href=/logout>Logout</a></div></div>";

			resp.getWriter().println(responseString);

		}
	}
}

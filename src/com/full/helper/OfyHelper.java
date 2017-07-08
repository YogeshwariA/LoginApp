package com.full.helper;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.full.model.User;
import com.googlecode.objectify.ObjectifyService;

public class OfyHelper implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
 
		ObjectifyService.register(User.class);
	}

	public void contextDestroyed(ServletContextEvent event) {
	}
}

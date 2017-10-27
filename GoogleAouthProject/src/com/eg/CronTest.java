package com.eg;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;


public class CronTest extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(CronTest.class.getName());
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		log.info("Hello world ");
		log.warning("Hello world ");
	}
}

package com.eg;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaskQueue1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		GoogleAouthProjectServlet gA = new GoogleAouthProjectServlet();
		for(int i=0;i<100; i++){
			gA.MailAPI("kalpana.krishna@a-cti.com");
		}
	}
	
}

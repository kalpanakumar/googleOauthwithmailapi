package com.eg;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

public class TaskQueue extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
			Queue queue = QueueFactory.getQueue("TestQueue");
			queue.add(TaskOptions.Builder.withUrl("/sendemail"));
	}
}



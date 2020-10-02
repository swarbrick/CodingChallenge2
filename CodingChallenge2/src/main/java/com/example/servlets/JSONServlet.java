package com.example.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servlets.JSONRequestHelper;

public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		JSONRequestHelper.process(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		JSONRequestHelper.process(req, res);
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		JSONRequestHelper.process(req, res);
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		JSONRequestHelper.process(req, res);
	}

}

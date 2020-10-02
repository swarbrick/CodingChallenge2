package com.example.servlets;

import javax.servlet.http.HttpServletRequest;

import com.example.controller.ForwardingController;


public class HTMLRequestHelper {

	public static String process(HttpServletRequest req) {
		
		System.out.println("THIS is the current URI active: "+req.getRequestURI());
		
		switch (req.getRequestURI()) {
		case "/CodingChallenge2/grocery-list/allGLists":
			return ForwardingController.allGLists(req);
		case "/CodingChallenge2/grocery-list/viewGList":
			return ForwardingController.viewGList(req);
		case "/CodingChallenge2/grocery-list/createItem":
			return ForwardingController.createItem(req);
		case "/CodingChallenge2/grocery-list/createList":
			return ForwardingController.createList(req);
		case "/CodingChallenge2/grocery-list/updateItem":
			return ForwardingController.updateItem(req);
		case "/CodingChallenge2/grocery-list/updateList":
			return ForwardingController.updateList(req);
		}
		return null;
	}

}

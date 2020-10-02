package com.example.controller;

import javax.servlet.http.HttpServletRequest;

public class ForwardingController {

	public static String allGLists(HttpServletRequest req) {
		return "/html/allGLists.html";
	}
	
	public static String viewGList(HttpServletRequest req) {
		return "/html/viewGList.html";
	}
	
	public static String createItem(HttpServletRequest req) {
		return "/html/createItem.html";
	}
	
	public static String createList(HttpServletRequest req) {
		return "/html/createList.html";
	}
	
	public static String updateItem(HttpServletRequest req) {
		return "/html/updateItem.html";
	}
	
	public static String updateList(HttpServletRequest req) {
		return "/html/updateList.html";
	}
}

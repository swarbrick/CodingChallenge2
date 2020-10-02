package com.example.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.JSONController;

public class JSONRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("THIS is the current URI active: "+req.getRequestURI());
		
		switch (req.getRequestURI()) {
		case "/CodingChallenge2/JSON/grocery-list":
			System.out.println("in get all lists JSON request");
			JSONController.getAllGLists(req, res); 
			break;
		case "/CodingChallenge2/JSON/grocery-list/list":
			System.out.println("in get all lists JSON request");
			JSONController.getGListById(req, res); 
			break;
		case "/CodingChallenge2/JSON/grocery-list/createList":
			System.out.println("in get all lists JSON request");
			JSONController.createList(req, res); 
			break;
		case "/CodingChallenge2/JSON/grocery-list/createItem":
			System.out.println("in get all lists JSON request");
			JSONController.createItem(req, res); 
			break;
		case "/CodingChallenge2/JSON/grocery-list/updateList":
			System.out.println("in get all lists JSON request");
			JSONController.updateList(req, res); 
			break;
		case "/CodingChallenge2/JSON/grocery-list/updateItem":
			System.out.println("in get all lists JSON request");
			JSONController.updateItem(req, res); 
			break;
		case "/CodingChallenge2/JSON/grocery-list/deleteList":
			System.out.println("in get all lists JSON request");
			JSONController.deleteList(req, res); 
			break;
		case "/CodingChallenge2/JSON/grocery-list/deleteItem":
			System.out.println("in get all lists JSON request");
			JSONController.deleteItem(req, res); 
			break;
		}
	}	
}

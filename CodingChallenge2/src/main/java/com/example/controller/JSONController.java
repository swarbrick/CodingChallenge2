package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.GListDao;
import com.example.dao.ItemDao;
import com.example.model.GList;
import com.example.model.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONController {

	public static void getAllGLists(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller: get all lists");
		List<GList> list = GListDao.getAllGLists();
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getGListById(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller: get list with items");
		GList list = GListDao.getGListByIdWithItems(Integer.parseInt(req.getParameter("listId")));
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller: create list");
		GList list = GListDao.createNewGList(req.getParameter("listTitle"), req.getParameter("comments"));
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void createItem(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller: create item");
		Item item = ItemDao.createNewItem(req.getParameter("itemName"), req.getParameter("comments"), req.getParameter("groceryType"), Integer.parseInt(req.getParameter("listId")));
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(item));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void updateList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller: update list");
		GList list = GListDao.updateGList(Integer.parseInt(req.getParameter("listId")), req.getParameter("listTitle"), req.getParameter("comments"));
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void updateItem(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller: update item");
		System.out.println(req.getParameter("itemId"));
		System.out.println(req.getParameter("itemName"));
		System.out.println(req.getParameter("comments"));
		System.out.println(req.getParameter("groceryType"));

		Item item = ItemDao.updateItem(Integer.parseInt(req.getParameter("itemId")), req.getParameter("itemName"), req.getParameter("comments"), req.getParameter("groceryType"));
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(item));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void deleteList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller: delete list");
		int status = GListDao.deleteGListById(Integer.parseInt(req.getParameter("listId")));
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(status));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void deleteItem(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller: delete item");
		int status = ItemDao.deleteItemById(Integer.parseInt(req.getParameter("itemId")));
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(status));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}

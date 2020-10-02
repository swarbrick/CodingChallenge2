package com.example.model;

import java.util.ArrayList;

public class GList {
	
	int listId;
	String listTitle;
	String comments;
	ArrayList<Item> groceriesOnList;
	
	public GList() {}

	public GList(int listId, String listTitle, String comments, ArrayList<Item> groceriesOnList) {
		super();
		this.listId = listId;
		this.listTitle = listTitle;
		this.comments = comments;
		this.groceriesOnList = groceriesOnList;
	}
	
	public GList(String listTitle, String comments, ArrayList<Item> groceriesOnList) {
		super();
		this.listTitle = listTitle;
		this.comments = comments;
		this.groceriesOnList = groceriesOnList;
	}
	
	public GList(int listId, String listTitle, String comments) {
		super();
		this.listId = listId;
		this.listTitle = listTitle;
		this.comments = comments;
	}
	
	public GList(String listTitle, String comments) {
		super();
		this.listTitle = listTitle;
		this.comments = comments;
	}



	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public ArrayList<Item> getGroceriesOnList() {
		return groceriesOnList;
	}

	public void setGroceriesOnList(ArrayList<Item> groceriesOnList) {
		this.groceriesOnList = groceriesOnList;
	}

	@Override
	public String toString() {
		return "GList [listId=" + listId + ", listTitle=" + listTitle + ", comments=" + comments + ", groceriesOnList="
				+ groceriesOnList + "]";
	}
}

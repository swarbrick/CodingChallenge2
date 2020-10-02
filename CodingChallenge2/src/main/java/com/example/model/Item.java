package com.example.model;

public class Item {

	int itemId;
	String itemName;
	String comments;
	String groceryType;
	int listId;
	
	public Item() {}

	public Item(int itemId, String itemName, String comments, String groceryType, int listId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.comments = comments;
		this.groceryType = groceryType;
		this.listId = listId;
	}
	
	public Item(String itemName, String comments, String groceryType, int listId) {
		super();
		this.itemName = itemName;
		this.comments = comments;
		this.groceryType = groceryType;
		this.listId = listId;
	}



	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getGroceryType() {
		return groceryType;
	}

	public void setGroceryType(String groceryType) {
		this.groceryType = groceryType;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", comments=" + comments + ", groceryType="
				+ groceryType + ", listId=" + listId + "]";
	}
		
}

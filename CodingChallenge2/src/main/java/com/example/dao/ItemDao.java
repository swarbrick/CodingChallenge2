package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.Item;

public class ItemDao {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static String url=System.getenv("PROJECT_0_URL");
	private static String username=System.getenv("PROJECT_0_USERNAME");
	private static String password=System.getenv("PROJECT_0_PASSWORD");
	
public static Item getItemById(int itemId) {
		
		
		System.out.println("get item by id");
		Item item = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM grocery_item WHERE item_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				item = new Item(rs.getInt("item_id"), rs.getString("item_name"), rs.getString("comments"), rs.getString("grocery_type"), rs.getInt("list_id"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(item);
		return item;
	}
	
	public static ArrayList<Item> getAllItems() {
			
			
			System.out.println("get all items");
			ArrayList<Item> list = new ArrayList<>();
			
			try(Connection conn = DriverManager.getConnection(url, username, password)) {
				String sql = "SELECT * FROM grocery_item";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new Item(rs.getInt("item_id"), rs.getString("item_name"), rs.getString("comments"), rs.getString("grocery_type"), rs.getInt("list_id")));
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			for (Item i : list) {
				System.out.println(i);
			}
			return list;
	}
	
	public static ArrayList<Item> getItemsFromListId(int listId) {
		
		
		System.out.println("get all items from list");
		ArrayList<Item> list = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM grocery_item WHERE list_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, listId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Item(rs.getInt("item_id"), rs.getString("item_name"), rs.getString("comments"), rs.getString("grocery_type"), rs.getInt("list_id")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		for (Item i : list) {
			System.out.println(i);
		}
		return list;
}
	
	public static Item createNewItem(String itemName, String comments, String groceryType, int listId) {
		System.out.println("create new item");
		Item item = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO grocery_item (item_name, comments, grocery_type, list_id) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setString(2, comments);
			ps.setString(3, groceryType);
			ps.setInt(4, listId);
			ps.executeUpdate();
			item = getMostRecentItem();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(item);		
		return item;		
	}
	
	public static Item updateItem(int itemId, String itemName, String comments, String groceryType) {
		System.out.println("update item");
		Item item = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE grocery_item SET item_name = ?, comments = ?, grocery_type = ? WHERE item_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setString(2, comments);
			ps.setString(3, groceryType);
			ps.setInt(4, itemId);
			ps.executeUpdate();
			item = getItemById(itemId);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(item);		
		return item;		
	}
	
	public static Item getMostRecentItem() {
		System.out.println("most recent item");
		Item item = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM grocery_item WHERE item_id = ("
					+ "Select MAX(item_id) from grocery_item"
					+ ")";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				item = new Item(rs.getInt("item_id"), rs.getString("item_name"), rs.getString("comments"), rs.getString("grocery_type"), rs.getInt("list_id"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(item);		
		return item;	
	}
	
	public static int deleteItemById(int itemId) {
		System.out.println("delete item");
		int status = 0;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "DELETE FROM grocery_item WHERE item_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);
			status = ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(status);		
		return status;	
	}

	public static void main(String[] args) {
		deleteItemById(1);
	}
}

package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.GList;
import com.example.model.Item;

public class GListDao {
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
	
	public static GList getGListById(int listId) {
		
		
		System.out.println("get list by id");
		GList list = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM grocery_list WHERE list_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, listId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				list = new GList(rs.getInt("list_id"), rs.getString("list_title"), rs.getString("comments"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(list);
		return list;
	}
	
	public static GList getGListByIdWithItems(int listId) {
		System.out.println("get list by id with items");
		GList list = null;
		ArrayList<Item> groceries = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM grocery_list WHERE list_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, listId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				list = new GList(rs.getInt("list_id"), rs.getString("list_title"), rs.getString("comments"));
			}	
			
			sql = "SELECT * FROM grocery_item WHERE list_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, listId);
			rs = ps.executeQuery();
			while(rs.next()) {
				groceries.add(new Item(rs.getInt("item_id"), rs.getString("item_name"), rs.getString("comments"), rs.getString("grocery_type"), rs.getInt("list_id")));
			}
			list.setGroceriesOnList(groceries);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(list);
		return list;
	}
	
	public static ArrayList<GList> getAllGLists() {		
		System.out.println("get all g lists");
		ArrayList<GList> list = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM grocery_list";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new GList(rs.getInt("list_id"), rs.getString("list_title"), rs.getString("comments")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		for (GList l : list) {
			System.out.println(l);
		}
		return list;
}
	
	public static GList createNewGList(String listTitle, String comments) {
		System.out.println("create new g list");
		GList list = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO grocery_list (list_title, comments) VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, listTitle);
			ps.setString(2, comments);
			ps.executeUpdate();
			list = getMostRecentGList();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(list);		
		return list;		
	}
	
	public static GList updateGList(int listId, String listTitle, String comments) {
		System.out.println("update g list");
		GList list = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE grocery_list SET list_title = ?, comments = ? WHERE list_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, listTitle);
			ps.setString(2, comments);
			ps.setInt(3, listId);
			ps.executeUpdate();
			list = getGListById(listId);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(list);		
		return list;		
	}
	
	public static GList getMostRecentGList() {
		System.out.println("most recent g list");
		GList list = null;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM grocery_list WHERE list_id = ("
					+ "Select MAX(list_id) from grocery_list"
					+ ")";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				list = new GList(rs.getInt("list_id"), rs.getString("list_title"), rs.getString("comments"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(list);		
		return list;	
	}
	
	public static int deleteGListById(int listId) {
		System.out.println("delete g list");
		int status = 0;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "DELETE FROM grocery_item WHERE list_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, listId);
			ps.executeUpdate();
			
			sql = "DELETE FROM grocery_list WHERE list_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, listId);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println(status);		
		return status;	
	}
	
	public static void main(String[] args) {
		getGListByIdWithItems(2);
	}

}

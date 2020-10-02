package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.Food;

public class FoodDao {
	
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
	
	public static ArrayList<Food> getAllFoods() {
		
		
		System.out.println("get all foods");
		ArrayList<Food> list = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM food";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Food(rs.getInt("food_id"), rs.getString("dish_name"), rs.getDouble("calories")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		for (Food f : list) {
			System.out.println(f);
		}
		return list;
	}

	public static void main(String[] args) {
		getAllFoods();

	}

}

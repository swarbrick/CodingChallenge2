package com.example.service;

import java.util.List;

import com.example.dao.FoodDao;
import com.example.model.Food;

public class FoodService {

	public static List<Food> getAllFoods() {
		return FoodDao.getAllFoods();
	}

}

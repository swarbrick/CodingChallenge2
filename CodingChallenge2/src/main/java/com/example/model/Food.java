package com.example.model;

public class Food {
	
	int foodId;
	String dishName;
	double calories;
	
	public Food() {}

	public Food(int foodId, String dishName, double calories) {
		super();
		this.foodId = foodId;
		this.dishName = dishName;
		this.calories = calories;
	}
	
	public Food(String dishName, double calories) {
		super();
		this.dishName = dishName;
		this.calories = calories;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", dishName=" + dishName + ", calories=" + calories + "]";
	}	

}

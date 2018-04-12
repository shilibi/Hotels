package com.zx.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class food {
	
	private int foodId;
	private String foodName;
	private float foodPrice;
	private char foodUnit;
	@Id
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public float getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}
	public char getFoodUnit() {
		return foodUnit;
	}
	public void setFoodUnit(char foodUnit) {
		this.foodUnit = foodUnit;
	}
	@Override
	public String toString() {
		return "food [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodUnit="
				+ foodUnit + "]";
	}
	
}

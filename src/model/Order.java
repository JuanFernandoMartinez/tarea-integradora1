package model;

public class Order {
	private String code,clientCode,restaurantNit,date;
	private int hour;
	
	public Order (String code, String clientCode,String restaurantNit,String date, int hour ) {
		this.clientCode = clientCode;
		this.code = code;
		this.restaurantNit = restaurantNit;
		this.date = date;
		this.hour = hour;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getRestaurantNit() {
		return restaurantNit;
	}

	public void setRestaurantNit(String restaurantNit) {
		this.restaurantNit = restaurantNit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
	
}
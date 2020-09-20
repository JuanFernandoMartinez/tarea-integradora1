package model;

import java.time.LocalDate;
import java.util.Calendar;

public class Order {
	private String code,clientCode,restaurantNit,date;
	private int hour;
	
	public Order ( String clientCode,String restaurantNit,String date, int hour ) {
		this.clientCode = clientCode;
		this.restaurantNit = restaurantNit;
		this.date = parseDate();
		this.hour = generateHour();
		this.code = generateCode();
	}

	
	/**
	 * generate the order code <br>
	 * <b>post:</b> returns a code with date,hour, restaurantNit,minutes,seconds and milliseconds <br>
	 * @return String with order code; 
	 */
	private String generateCode() {
		String auxDate = date;
		auxDate.replace(" / ", "");
		Calendar calendar = Calendar.getInstance();
		String extraInfo = calendar.get(Calendar.MINUTE)+""+calendar.get(Calendar.SECOND)+calendar.get(Calendar.MILLISECOND);
		String cd = auxDate+hour+restaurantNit+extraInfo;
		return cd;
	}

	
	/**
	 * gets the actuar hour <br>
	 * @return int with hour
	 */
	private int generateHour() {
		Calendar calendario = Calendar.getInstance();
		int h = calendario.get(Calendar.HOUR);
		return h;
	}

	/**
	 * gets String with date
	 * @return String with date (year,month and day of month
	 */
	private String parseDate() {
		String strDate = "";
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		int day = LocalDate.now().getDayOfMonth();
		
		strDate = year+" / "+month+" / "+day;
		return strDate;
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
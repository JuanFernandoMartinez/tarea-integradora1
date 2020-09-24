package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

import exceptions.InvalidStatusException;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private String code,clientCode,restaurantNit,date;
	private int hour;
	private OrderStatus status;
	
	public Order ( String clientCode,String restaurantNit) {
		this.clientCode = clientCode;
		this.restaurantNit = restaurantNit;
		this.date = parseDate();
		this.hour = generateHour();
		this.code = generateCode();
		this.status = OrderStatus.RECUESTED;
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
	 * gets the actual hour <br>
	 * @return integer with hour
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

	/**
	 * set the actual hour to the attribute <br>
	 */
	public void setHour() {
		Calendar calendario = Calendar.getInstance();
		hour = calendario.get(Calendar.HOUR);
	}
	

	/**
	 * change the Order status <br>
	 * <b>pre:</b> the integer given by params mus be in range[0,3]<br>
	 * @param x integer with the value of new status 
	 * @throws InvalidStatusException if the status value given is less or equals to the actual status 
	 */
	public void changeStatus(int x) throws InvalidStatusException {
		if (this.status.getStatus() < x) {
			this.status.setStatus(x);
		}else {
			throw new InvalidStatusException();
		}
	}


}
	
	

package model;

import java.io.Serializable;

public class Restaurant  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private String name,nit,admin;
	
	/**
	 * creates a Restaurant object with the info given by parameters <br>
	 * <b>post</b> creates a Restaurant object <br>
	 * @param name String with the name of the restaurant !null
	 * @param nit String with the registration code of the restaurant !null
	 * @param admin String with name of the admin !null
	 */
	public Restaurant(String name, String nit, String admin) {
		this.name = name;
		this.nit = nit;
		this.admin = admin;
	}

	/**
	 * get the name of the restaurant
	 * @return String with name of the Restaurant 
	 */
	public String getName() {
		return name;
	}


	/**
	 * replace the restaurant name with the String given by parameters
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public String getAdmin() {
		return admin;
	}


	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	

}

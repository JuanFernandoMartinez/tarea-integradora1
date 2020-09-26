package model;

import java.io.Serializable;

public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IdType idType;
	private String id,firstName,lastName,phone,adress;
	
	
	/**
	 * creates a new Client object
	 * @param type integer x 0<=x<=3
	 * @param id String !null !empty
	 * @param firstName String !null !empty
	 * @param lastName String !null !empty
	 * @param phone String !null !empty
	 * @param adress String String !null !empty
	 */
	public Client (IdType type,String id, String firstName,String lastName, String phone, String adress) {
		this.idType = type;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.adress = adress;
	}
	
	
	public IdType getIdType() {
		return idType;
	}
	
	
	public void setIdType(IdType idType) {
		this.idType = idType;
	}
	
	
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	
	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}


	
	
	
	
	
}

package model;

public class Restaurant {
	private String name,nit,admin;
	
	
	public Restaurant(String name, String nit, String admin) {
		this.name = name;
		this.nit = nit;
		this.admin = admin;
	}


	public String getName() {
		return name;
	}


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

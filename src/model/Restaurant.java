package model;

import java.io.Serializable;

public class Restaurant  implements Serializable, Comparable<Restaurant>{
	
	private static final long serialVersionUID = 1;
	private String name,nit,admin;
	
	/**
	 * creates a Restaurant object with the info given by parameters <br>
	 * <b>post</b> creates a Restaurant object <br>
	 * @param name String !null !empty
	 * @param nit String !null !empty
	 * @param admin String !null !empty
	 */
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


	@Override
	public int compareTo(Restaurant o) {
		if (name.equals(o.name)) {
			return 0;
		}else if (name.compareTo(o.name) == 1) {
			return 1;
		}else {
			return -1;
		}
		
	}
	
	

}

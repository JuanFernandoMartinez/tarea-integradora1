package model;

import java.io.Serializable;

public class Product implements Serializable, Comparable <Product> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private String code,name,info,nit;
	private double cost;
	
	/**
	 * creates a new Product object
	 * @param code String !null !empty
	 * @param name String !null !empty
	 * @param info String !null !empty
	 * @param nit String !null !empty
	 * @param cost double x ; x> 0 
	 */
	public Product(String code, String name, String info, String nit,double cost) {
		this.code = code;
		this.info = info;
		this.name = name;
		this.nit = nit;
		this.cost = cost;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Product o) {
		if (name.equals(o.name)) {
			return 0;
		}else if (name.compareTo(o.name)==1) {
			return 1;
		}else {
			return -1;
		}
		
	}
	
	
}

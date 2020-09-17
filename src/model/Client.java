package model;

public class Client {
	private IdType idType;
	private String id,name,phone,adress;
	
	public Client (IdType type,String id, String name, String phone, String adress) {
		this.idType = type;
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

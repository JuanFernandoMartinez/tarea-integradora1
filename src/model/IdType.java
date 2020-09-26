package model;

public enum IdType {
	CC("cedula de ciudadania"),
	TI("Targeta de identidad"),
	CE("Cedula de Extrageria"),
	PP("Pasaporte");
	
	private String type;
	
	IdType(String type){
		this.type = type;
	}
}

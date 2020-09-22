package model;

public enum OrderStatus {
	RECUESTED(0),
	INPROCESS(1),
	SENT(2),
	DELIVERED(3);
	
	private int status;
	
	OrderStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}

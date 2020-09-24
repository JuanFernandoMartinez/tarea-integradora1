package exceptions;

public class ClientNotFoundException extends Exception{
	public ClientNotFoundException() {
		super("The client wasn't found");
	}

}

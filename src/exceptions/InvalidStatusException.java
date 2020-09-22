package exceptions;

public class InvalidStatusException extends Exception{
	public InvalidStatusException() {
		super("The status ingresed is wrong");
	}

	
}

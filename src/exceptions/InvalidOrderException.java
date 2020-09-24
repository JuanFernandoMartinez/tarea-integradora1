package exceptions;

public class InvalidOrderException extends Exception{

	public InvalidOrderException() {
		super("The order is wrong");
	}
}

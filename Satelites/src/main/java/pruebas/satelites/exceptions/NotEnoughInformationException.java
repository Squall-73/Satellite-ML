package pruebas.satelites.exceptions;

public class NotEnoughInformationException extends Exception{

	// exception thrown when satellites do not bring enough information
	public NotEnoughInformationException(String msg){
		super(msg);
	}
}

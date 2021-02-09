package assignment;
public class WeakPasswordException extends Exception{
	
	public WeakPasswordException(){
		super("Password is OK but weak");
	}
	
	public WeakPasswordException(String message) {
		super(message);
	}
}

/**
 * PersonalizedException is a custom exception class that is used to throw and handle personalized exceptions.
 * It extends the Exception class
 * @author     Javi
 * @version   1.0
 */
package exceptions;

public class PersonalizedException extends Exception{
	/**
	 * PersonalizedException is a custom exception class that can be used to throw and handle personalized exceptions.
	 */
	public PersonalizedException() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor of the class PersonalizedException
	 * @param message the message of the exception
	 * @param cause the cause of the exception
	 * @param enableSuppression  whether or not suppression is enabled or disabled.
	 * @param writableStackTrace whether or not the stack trace should be writable
	 */
	public PersonalizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructs a new PersonalizedException with the specified detail message and cause.
	 * @param message the message of the exception
	 * @param cause the cause of the exception
	 */
	public PersonalizedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new PersonalizedException with the specified detail message.
	 * @param message the message of the exception
	 */
	public PersonalizedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new PersonalizedException with the specified cause.
	 * @param cause the cause of the exception
	 */
	public PersonalizedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}

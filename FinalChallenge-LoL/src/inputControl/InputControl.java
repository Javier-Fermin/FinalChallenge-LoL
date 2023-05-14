/**
 * The InputControl class is used to validate the inputs of the user
 * @author Irati
 * @version 1.0
 */
package inputControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputControl {
	private boolean correct;

	/**
	 * Validates the email of the user.
	 * @param email the email of the user
	 * @return true if the email is correct, false if it is not.
	 */
	public boolean validateEmail(String email) {
		correct = true;
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher match = pattern.matcher(email);
        if(!match.find()== true) {
        	correct= false;
        }
        
        return correct;
	}

	/**
	 * Validates the password of the user.
	 * @param nickname the password of the user
	 * @return true if the password is correct, false if it is not.
	 */
	public boolean validateNickname(String nickname) {
		correct = true;
		if(nickname.split("\\s+").length != 1) {
			correct= false;	
		}
		return correct;
	}

	/** 
	 * Validates the name of the user.
	 * @param name the name of the user
	 * @return true if the name is correct, false if it is not.
	*/
	public boolean validateString(String string) {
		correct = true;
		if(!string.matches("[A-Z a-z]+")){
			correct=false;
		}
		return correct;
	}
	
	/**
	 * Validates the phone of the user
	 * @param number the phone of the user
	 * @return true if the phone is correct, false if it is not.
	 */
	public boolean validateInteger(String number) {
		correct= false;
		if(number.matches("[0-9]+")) {
			correct= true;
		}
		return correct;
	}
}

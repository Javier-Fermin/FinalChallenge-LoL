package inputControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputControl {
	private boolean correct;

	// Method to validate mails
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

	// Method to validate nicknames
	public boolean validateNickname(String nickname) {
		correct = true;
		if(nickname.split("\\s+").length != 1) {
			correct= false;	
		}
		return correct;
	}

	// Method to validate strings
	public boolean validateString(String string) {
		correct = true;
		if(!string.matches("[A-Z a-z]+")){
			correct=false;
		}
		return correct;
	}
	
	// Method to validate numbers
	public boolean validateInteger(String number) {
		correct= false;
		if(number.matches("[0-9]+")) {
			correct= true;
		}
		return correct;
	}
}

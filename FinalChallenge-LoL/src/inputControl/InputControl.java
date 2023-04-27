package inputControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputControl {
	private boolean correct;
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
	public boolean validatePhone(String phone) {
		correct = true;
		if(phone.length()!=9 || !phone.matches("[0-9]+")) {
			correct= false;
		}
		return correct;
	}
	
	public boolean validateNickname(String nickname) {
		correct = true;
		if(nickname.split("\\s+").length != 1) {
			correct= false;	
		}
		return correct;
	}
	public boolean validateString(String string) {
		correct = true;
		if(!string.matches("[A-Z a-z]+")){
			correct=false;
		}
		return correct;
	}
	
	public boolean validateInteger(int number) {
		
		return correct;
	}
}

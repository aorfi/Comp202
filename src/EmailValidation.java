//260722166 Alev Orfi
//Validates email adresses 
public class EmailValidation {
	public static void main(String[] args) {
		System.out.println(isValidEmail(args[0]));
		
	}
	
	public static boolean isLetter(char a) {//Checks if character is letter or number
		int code = (int) a;
		if(code > 64  && code < 91 || code > 96  && code < 122 ) {
			return true;	
		}
		else {
			return false;
		}	
	}
	
	
	public static boolean isAlphanumeric(char a) {//Checks if character is letter or number
		int code = (int) a;
		if(code > 47 && code <58 || code > 64  && code < 91 || code > 96   && code < 122 ) {
			return true;	
		}
		else {
			return false;
		}	
	}
	
	
	public static boolean isValidPrefixChar(char a) {//Checks if character is alphanumeric, a dash, a period or an underscore
		int code = (int) a;
		boolean Alpha = isAlphanumeric(a);
		if( Alpha == true || code > 44 && code < 47 || code == 95 ) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	public static boolean isDomainChar(char a) {//Checks if character is alphanumeric, a dash or a period
		int code = (int) a;
		boolean Alpha = isAlphanumeric(a);
		if( Alpha == true || code > 44 && code < 47 ) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	public static boolean exactlyOneAt(String s) {//checks to see if string has one @
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			int code = s.charAt(i);
			if(code == 64) {
				count++;
			}
		}
		if(count == 1) {//if there is only 1
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static String getPrefix(String s) {//returns the part of the string before the @
		String prefix = "";
		for(int i = 0; i < s.length(); i++) {//runs through the string
			int code = s.charAt(i);
			if(code == 64) {//exits for loop at @
				break;	
			}
			char codeChar =(char) code;
			prefix = prefix + codeChar;	//updates the prefix to include the char if its before the @
		}
		return prefix;
	}
	
	
	public static String getDomain(String s) {//returns the part of the string before the @
		String domain = "";
		boolean afterAt = false;
		for(int i = 0; i < s.length(); i++) {//runs through the string
			int code = s.charAt(i);
			char codeChar =(char) code;
			if(afterAt == true) {//if after the @
				domain = domain + codeChar;	//updates the prefix to include the char
			}
			if(code == 64) {//finds position of @
				afterAt = true;
			}
		}
		return domain;
	}
	
	
	public static boolean isValidPrefix(String s) {//checks is string is a valid prefix
		if(s.length() < 0 || isAlphanumeric(s.charAt(0)) == false ) {//makes sure it contains at least on character and the first is alphanumeric	
			return false;
		}
		
		for(int i = 0; i < s.length(); i++) {//runs through the string
			if(isValidPrefixChar(s.charAt(i)) == false ) {//checks if each character is valid prefix character
				return false;
			}
			
			if(s.charAt(i) > 44 && s.charAt(i) < 47 || s.charAt(i) == 95) {//checks if it has underscore, period or dash
				if(i+1 != s.length()) {//if the position of this underscore, period or dash isn't at the end 
					if (isAlphanumeric(s.charAt(i+1)) == false) {//check if the following character is alphanumeric
					return false;
					}
				}
			}
		}
		return true;
	}
	
	public static String getFirstDomainPart(String s) {
		String fistPart = "";
		int splitPosition = 0;
		for(int i = 0; i < s.length(); i++) {//runs through the string
			int code = s.charAt(i);
			if(code == 46) {//adds value 
				splitPosition = i;
			}
		}
		for(int i = 0; i < splitPosition; i++) {//runs through the string
			int code = s.charAt(i);
			char codeChar =(char) code;
			fistPart = fistPart + codeChar;	//updates the firstPart to include the char if its before the .
		}
		return fistPart;	
	}
	
	
	public static String getSecondDomainPart(String s) {
		String secondPart = "";
		int splitPosition = 0;
		for(int i = 0; i < s.length(); i++) {//runs through the string
			int code = s.charAt(i);
			if(code == 46) {//adds value 
				splitPosition = i;
			}
		}
		for(int i = splitPosition +1 ; i < s.length(); i++) {//runs through the string
			int code = s.charAt(i);
			char codeChar =(char) code;
			secondPart = secondPart + codeChar;	//updates the firstPart to include the char if its before the .
		}
		return secondPart;
	}
	
	
	public static boolean isValidDomain(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {//runs through string
			int code = s.charAt(i);
			if(code == 46) {//checks if there is a period
				count++;
			}
		}
		if(count != 0) {//if there at least period
			String fPart = getFirstDomainPart(s);
			String sPart = getSecondDomainPart(s);
			if(fPart.length() < 1 || sPart.length() < 2) {//checks if sections are the correct length
				return false;
			}
			
			for(int i=0; i<fPart.length(); i++ ) {
				if(isDomainChar(fPart.charAt(i)) == false ) {//checks if each character is valid prefix character
					return false;
				}
				if(fPart.charAt(i) > 44 && fPart.charAt(i) < 47) {//checks if it has a period or dash
					if(i+1 != fPart.length()) {//if the position of this period or dash isn't at the end 
						if (isAlphanumeric(s.charAt(i+1)) == false) {//check if the following character is alphanumeric
							return false;
						}
					}
					else {//position of period or dash is at the end
						return false;
					}
				}
			}
			
			for(int i=0; i<sPart.length();i++ ) {
				if(isLetter(sPart.charAt(i)) == false ) {//checks if each character is valid prefix character
					return false;
				}		
			}
		}
		else {//there is no period
			return false;
		}
	return true;	
	}
	
	
	public static boolean isValidEmail(String s) {
		String domain = getDomain(s);//get domain
		String prefix = getPrefix(s);//get prefix
		if (isValidDomain(domain) == true && isValidPrefix(prefix)== true) {//checks is both prefix and main are good
			return true;
		}
		else {
			return false;
		}
	}
	
}

package com.group2.package1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {	
	public static boolean isEmailAddress(String email) {
		String emailPattern = "^[a-zA-Z0-9.]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher regularExpressionMatcher = pattern.matcher(email);	
		return regularExpressionMatcher.matches();
	}	
}

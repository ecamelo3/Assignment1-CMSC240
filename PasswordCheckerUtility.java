package assignment;
/*@author Emma Camelo
 * Monshi CMSC240 - 2/8/2020
 */

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * 
 */

public class PasswordCheckerUtility extends java.lang.Object {
	
	public PasswordCheckerUtility() {}
	
	/* Compare equality of two passwords
	 * @param passwordConfirm
	 * @param password
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if(!(password.equals(passwordConfirm))) 
			throw new UnmatchedException();
	}
	
	/* Compare equality of two passwords and returns the value
	 * @param password
	 * @param passwordConfirm
	 * @returns true if password equals password confirm
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if (password.contentEquals(passwordConfirm))
			return true;
		else
			return false;
	}
	
	/* Reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
	 * @param password
	 * @returns file of rejected passwords and why
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> results = new ArrayList<String>();
		
		for(int x = 0; x < passwords.size(); x++)
		{
			try {
				PasswordCheckerUtility.isValidLength(passwords.get(x));
				PasswordCheckerUtility.hasUpperAlpha(passwords.get(x));
				PasswordCheckerUtility.hasLowerAlpha(passwords.get(x));
				PasswordCheckerUtility.hasDigit(passwords.get(x));
				PasswordCheckerUtility.hasSpecialChar(passwords.get(x));
				PasswordCheckerUtility.hasSameCharInSequence(passwords.get(x));
			}
			catch(NoUpperAlphaException e) {
				results.add(passwords.get(x) + " -> " + e.getMessage());
			}
			catch(NoLowerAlphaException e) {
				results.add(passwords.get(x) + " -> " + e.getMessage());
			}
			catch(NoDigitException e) {
				results.add(passwords.get(x) + " -> " + e.getMessage());
			}
			catch(NoSpecialCharacterException e) {
				results.add(passwords.get(x) + " -> " + e.getMessage());
			}
			catch(InvalidSequenceException e) {
				results.add(passwords.get(x) + " -> " + e.getMessage());
			}
			catch(LengthException e) {
				results.add(passwords.get(x) + " -> " + e.getMessage());
			}	
		}
		return (results);
	}
	
	/* Password contains 6 to 9 characters , still considers valid, just weak
	 * @param password  
	 *  @returns true if password is 6-9 characters
	 */
	public static boolean	hasBetweenSixAndNineChars(String password) {
		if(password.length()>= 6 && password.length()<= 9)
			return true;
		else
			return false;
	}
	
	/* Checks password for a digit
	 * @param password
	 * @returns if digit is found
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		String re = ".*\\d.*";
		
		Pattern pt = Pattern.compile(re);
		Matcher mt = pt.matcher(password);
		
		if(mt.matches() == true) {
			return true;
		}
		else
			throw new NoDigitException();
	}
	
	/*Checks for lowercase character
	 * @password
	 * @returns true when it finds lowercase
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		String re = ".*[a-z].*";
		
		Pattern pt = Pattern.compile(re);
		Matcher mt = pt.matcher(password);
		
		if(mt.matches() == true) {
			return true;
		}
		else
			throw new NoLowerAlphaException();
	}
	
	/* Checks the sequence for two same characters in a row
	 * @param password
	 * @returns
	 */
	public static boolean hasSameCharInSequence(String password)  throws InvalidSequenceException {
		for(int x = 0; x <= password.length() - 3; x++) {
			if(password.charAt(x) == password.charAt(x+1) && password.charAt(x) == password.charAt(x+2))
				throw new InvalidSequenceException();
		}
		return true;
	}
	
	/* Checks for special character
	 * @param password
	 * @returns true if special character is found
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		String re = ".*[`~!@#$%^&*()\\\\-_=+\\\\\\\\|\\\\[{\\\\]};:'\\\",<.>/?].*";
		
		Pattern pt = Pattern.compile(re);
		Matcher mt = pt.matcher(password);
		
		if(mt.matches() == true) {
			return true;
		}
		else {
			throw new NoSpecialCharacterException();
		}
	}
	
	/* Checks for upper case character
	 * @param password
	 *  @return true if upper case is found
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		String re = ".*[A-Z].*";
		
		Pattern pt = Pattern.compile(re);
		Matcher mt = pt.matcher(password);
		
		if(mt.matches() == true) {
			return true;
		}
		else
			throw new NoUpperAlphaException();
	}
	
	/* Checks if password is at least 6 characters
	 * @param password
	 * @return true if password 6+ char
	 */
	public static boolean isValidLength(String password) throws LengthException{
		if(password.length() >= 6)
			return true;
		throw new LengthException();
	}
	
	/* @param password
	 * 
	 */
	public static boolean isValidPassword(String password) throws LengthException,
    NoUpperAlphaException,
    NoLowerAlphaException,
    NoDigitException,
    NoSpecialCharacterException,
    InvalidSequenceException 
	{
		if(PasswordCheckerUtility.isValidLength(password) == false)
			return false;
		if(PasswordCheckerUtility.hasUpperAlpha(password) == false)
			return false;
		if(PasswordCheckerUtility.hasLowerAlpha(password) == false)
			return false;
		if(PasswordCheckerUtility.hasDigit(password) == false)
			return false;
		if(PasswordCheckerUtility.hasSpecialChar(password) == false)
			return false;
		if(PasswordCheckerUtility.hasSameCharInSequence(password) == false)
			return false;
		
//		try {
//			PasswordCheckerUtility.isValidLength(password);
//			PasswordCheckerUtility.hasUpperAlpha(password);
//			PasswordCheckerUtility.hasLowerAlpha(password);
//			PasswordCheckerUtility.hasDigit(password);
//			PasswordCheckerUtility.hasSpecialChar(password);
//			PasswordCheckerUtility.hasSameCharInSequence(password);
//		}
//		catch(Exception e) {
//			return false;
//		}
		return true;
	}
	
	/*
	 * 
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
			if(PasswordCheckerUtility.hasBetweenSixAndNineChars(password) == true)
				throw new WeakPasswordException();
		
		return false;
	}

}

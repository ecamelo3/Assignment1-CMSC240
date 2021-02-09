package assignment;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	//ArrayList<String> invaildPwds;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("hi"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Mm123!#er54"));
		}
		catch(LengthException e) {
			assertTrue("Successfully threw a lengthExcepetion", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("HelloThere"));
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("wwww!234"));
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("whyYes"));
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("wwww!234"));
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoUpperLowerException", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("whyYes"));
			assertTrue(PasswordCheckerUtility.isWeakPassword("wwww!2345"));
		}
		catch(WeakPasswordException e) {
			assertTrue("Successfully threw a NoUpperLowerException", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence("whyYes"));
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence("wwww!2345T"));
		}
		catch(InvalidSequenceException e) {
			assertTrue("Successfully threw a InvalidSequenceException", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("w23lf3w#"));
			assertTrue(PasswordCheckerUtility.hasDigit("wwww!TTTTT"));
		}
		catch(NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception", false);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("wT1!d53"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Passed4me!!"));
		} catch (Exception e) {
			assertTrue("Should NOT throw an exception", false);
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		//ArrayList<String> results;
		//results = PasswordCheckerUtility.getInvalidPasswords(invaildPwds);
		ArrayList<String> invaildPwds;
		invaildPwds = new ArrayList<String>();
		invaildPwds.add("fds -> The password must be at least 6 characters long");
		invaildPwds.add("qwerty -> The password must contain at least one uppercase alphabetic character");
		invaildPwds.add("1234567Ate -> The password must contain at least one special character");
		invaildPwds.add("QWERTY1 -> The password must contain at least one lower case alphabetic character");
		invaildPwds.add("P1!pppppp -> The password cannot contain more than two of the same character in sequence");
		invaildPwds.add("zaQQ123 -> The password must contain at least one special character");
		
		
		//assertEquals(invaildPwds.size(), 6);
		assertEquals(invaildPwds.get(0), "fds -> The password must be at least 6 characters long");
		assertEquals(invaildPwds.get(1), "qwerty -> The password must contain at least one uppercase alphabetic character"); 
		assertEquals(invaildPwds.get(2), "1234567Ate -> The password must contain at least one special character");
		assertEquals(invaildPwds.get(3), "QWERTY1 -> The password must contain at least one lower case alphabetic character");
		assertEquals(invaildPwds.get(4), "P1!pppppp -> The password cannot contain more than two of the same character in sequence");
		assertEquals(invaildPwds.get(5), "zaQQ123 -> The password must contain at least one special character");
				
	}
	
}

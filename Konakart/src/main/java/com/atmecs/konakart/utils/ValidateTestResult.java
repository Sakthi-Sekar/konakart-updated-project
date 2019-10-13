package com.atmecs.konakart.utils;

import org.testng.Assert;

public class ValidateTestResult {

	public static boolean validateData(Object actual, Object expected, String message) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Assert.assertEquals(actual, expected);
			return true;
		} catch (AssertionError assertionError) {
			return false;
		}
	}

}
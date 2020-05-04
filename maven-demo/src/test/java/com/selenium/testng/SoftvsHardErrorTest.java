package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;

public class SoftvsHardErrorTest {
  
 @Test
 public void hardError() {
	 System.out.println("Inside test: hardError"); 
	 assertTrue(2<1);
	 System.out.println("assertTrue(2<1): Hard Assertion Failed");
	 assertFalse(1<2);
	 System.out.println("assertFalse(1<2): Hard Assertion Failed");
 }
	
  @Test
  public void softError() {
	  System.out.println("Inside test: softError");
	  SoftAssert sa= new SoftAssert();
	  sa.assertTrue(2<1);
	  System.out.println("assertTrue(2<1): Soft Assertion Failed");
	  sa.assertFalse(1<2);
	  System.out.println("assertFalse(1<2): Soft Assertion Failed");
	  sa.assertEquals("Sample", "Failed");
	  System.out.println("assertEquals: Soft Assertion Failed");
	  sa.assertAll();
  
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}

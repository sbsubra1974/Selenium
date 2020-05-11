package com.selenium.testng;

import org.testng.annotations.Test;

import com.selenium.po.SeleniumWebDriverUploadFilePageObject;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.testng.annotations.AfterClass;

public class RemoteFilePathTest {
  @Test
  public void f() throws URISyntaxException {
	  URL resource = RemoteFilePathTest.class.getResource("/com/selenium/webpages/SeleniumWebdriverUploadFile.html");
	  System.out.println("path: "+Paths.get(resource.toURI()).toFile().getPath()); 
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}

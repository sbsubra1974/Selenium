package com.selenium.testng;

/* 13-May-2020: INCOMPLETE: Stopped Selenium study here. maven-demo project folder pushed to GitHub and Jenkins wporkspace
 * 
 * */

import org.testng.annotations.Test;

import com.selenium.util.FTPFileTransfer;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SendFTPFileTest {
  
	FTPFileTransfer ftp;
	
  @Test
  public void f() {
  
	  //send the static HTML file to the remote server
	  ftp = new FTPFileTransfer();
	  ftp.ftpFileTransfer("192.168.1.5", 4444, "/maven-demo/src/main/resources/com/selenium/webpages/SeleniumWebdriverUploadFile.html","SeleniumWebdriverUploadFile.html");
  
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}

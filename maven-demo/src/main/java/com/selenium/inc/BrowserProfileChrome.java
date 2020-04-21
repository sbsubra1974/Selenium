package com.selenium.inc;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserProfileChrome {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
				
		ChromeOptions m_Options = new ChromeOptions();
		//m_Options.addArguments("--user-data-dir=C:/Users/User/AppData/Local/Google/Chrome/User Data");
		m_Options.addArguments("--user-data-dir=F:/Users/User");
		m_Options.addArguments("profile-directory=Profile 2");
		m_Options.addArguments("--disable-extensions");
		WebDriver webdriver = new ChromeDriver(m_Options);
		
		try {
			webdriver.get("https://www.google.com/");
			Thread.sleep(5000);
			webdriver.findElement(By.name("q")).sendKeys("selenium");
		}
			finally {
			//webdriver.quit();
			}

	}

}

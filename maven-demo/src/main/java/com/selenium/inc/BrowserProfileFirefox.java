package com.selenium.inc;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserProfileFirefox {

		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");		
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile(new File("C:\\Users\\User\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\fpor0gux.Selenium")));
			WebDriver webdriver = new FirefoxDriver(options);
			
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

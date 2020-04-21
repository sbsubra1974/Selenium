package com.selenium.util;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.GitHubPageObjectFactory;

public class BoilerPlateClass {

	protected WebDriver webdriver;
	protected Object pgobjref;  //for setupWebdriverReflection()
	protected Actions actions;
	protected WebDriverWait wait;
	protected int waitDuration = 5;
	
	public void setupWebdriver() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		actions = new Actions(webdriver);
		wait = new WebDriverWait(webdriver,waitDuration);		
	
	}
	
	public void setupWebdriverReflection(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException { //https://stackoverflow.com/questions/17849385/passing-class-name-as-parameter

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		webdriver = new ChromeDriver();
		
		//https://stackoverflow.com/questions/17849385/passing-class-name-as-parameter
		pgobjref = Class.forName(className).getDeclaredConstructor().newInstance();

		actions = new Actions(webdriver);
		wait = new WebDriverWait(webdriver,waitDuration);		
	
	}
}


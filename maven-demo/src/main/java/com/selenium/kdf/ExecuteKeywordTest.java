package com.selenium.kdf;

import java.util.List;
import java.util.Properties;
import com.selenium.kdf.ReadObject;
import com.selenium.kdf.ElementsClass;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteKeywordTest {

	public static void main(String[] args) throws Exception {
	
	//driver full path required when running from Jenkins	
	System.setProperty("webdriver.chrome.driver","F:\\Users\\User\\eclipse-workspace\\maven-demo\\drivers\\chromedriver.exe");
	String TestCaseFilePath="C:\\Users\\User\\Downloads\\Training\\Selenium\\New folder\\TestKeywords";
	String TestCaseWorkBookName="TestCase.xlsx";
	String TestCaseWorkSheetName="keywordsheet";
	String propertyFilePath=System.getProperty("user.dir")+"\\objects\\objects.properties";
	WebElement element;
	List<WebElement>elements;
	String Keyword;
	String UIElement;
	String ElementLocatorType;
	String Parameter;
	String RunFlag="N";
	Boolean jsexec=false;
	
	WebDriver webdriver = new ChromeDriver();
	ReadExcelFile file = new ReadExcelFile();
	ReadObject object = new ReadObject();
	Properties objectRepo = object.getObjectRepository();
	ElementsClass elementsClass = new ElementsClass();
	
	
	//Read keyword sheet
	Sheet KeyWorkSheet = file.readExcel(TestCaseFilePath,TestCaseWorkBookName,TestCaseWorkSheetName);
	//Find number of rows in excel file
	    int rowCount = KeyWorkSheet.getLastRowNum()-KeyWorkSheet.getFirstRowNum();
	    //Create a loop over all the rows of excel file to read it
  for (int i = 1; i < rowCount+1; i++) {
	        //Loop over all the rows
	        Row row = KeyWorkSheet.getRow(i);	        
	        
	        //Check if the first cell contain a value, if yes, That means it is the new testcase name
	        if(row.getCell(0,Row.MissingCellPolicy.RETURN_NULL_AND_BLANK)==null){
	        
	    	//Execute testcase only if the RunFlag="Y"
	        if ((RunFlag.compareTo("Y")==0))
	    	{
	    		//assign values from keyword sheet to local variables for readability
	        	Keyword=new String(row.getCell(1).toString());
	            UIElement=new String(row.getCell(2).toString());
	            ElementLocatorType=new String(row.getCell(3).toString());
	            Parameter=new String(row.getCell(4).toString());
	            
	            	//Always begin a test run with jsFlag and jsexec as "false"(A stray program exit could have left jsFlag to "true" in the last run) 
	            	object.resetJSFlag(propertyFilePath,"jsFlag","false");
	            	jsexec = false;
	            
	            	//Print testcase detail on console
	            	System.out.println(Keyword+"----"+ UIElement+"----"+ ElementLocatorType+"----"+ Parameter);
	            	
	            	//GOTOURL is a special keyword:does not have UIElement or ElementLocatorType values in keywordsheet
	            	if(Keyword.compareTo("GOTOURL")==0)
	            		elementsClass.openBrowserPage(webdriver,objectRepo,Parameter);
	            	
	            		//Unsorted list
	            	else if(Keyword.compareTo("SEARCHLIST")==0)
	            	{
	            		//split UIElement: 
	            		/*i. ul,li UI Elements are stored in the same cell in keywordsheet 
	            		 * to maintain in-memory ul WebElement object. Else, we will have to 
	            		 * Serialise ul object to an external file-which cannot be done 
	            		 * since WebElement class cannot be serialised
	            		 * Storing ul locator temporary as a string in object.properties would require calling 
	            		 * findElement again to get ul element object before we pass it to get all corresponding 
	            		 * list elements: 
	            		 * [i.e List<WebElement>li_elements=ul_element.findElement(By.<locatorType>(ul locator type))
	            		 * But this would mean doing a switch-case again for By.<locatorType> and complete re-modelling of framework functions return types
	            		 * Storing ul locator temporary as a string in an external file will also cause the above issue+possible security breach in storing and retrieving the file in a CI/CD server or shared file server
	            		 * ii. We will not be setting jsexec because JavaScriptExecutor will not be called executing commands on ul/li.
	            		 * The reasons are: 
	            		 * ul/li are dynamic and will not be hidden or overlayed by another element
	            		 * JavaScript Executor command may not be able to a)find the ul element b)find the li elements c)loop over the li elements <check>   
	            		 */
	            		String[] arr=UIElement.split(",");
	            		String UIElement_ul=new String(arr[0]);
	            		String UIElement_li=new String(arr[1]);
	            		
	            		//split ElementLocatorType
	            		arr=ElementLocatorType.split(",");
	            		String ElementLocatorType_ul=new String(arr[0]);
	            		String ElementLocatorType_li=new String(arr[1]);
	            		
	            		//call elementsClass.findElementOnPage() for each set of UIElement and ElementLocatorType
	            		element = elementsClass.findElementOnPage(webdriver,objectRepo,Keyword, ElementLocatorType_ul, UIElement_ul,propertyFilePath,object);	            	
	            		elements = elementsClass.finduiListElements(webdriver,objectRepo,element, ElementLocatorType_li, UIElement_li,propertyFilePath,object);
	            		
	            		//from elements WebElement List, search for Parameter element and return
	            		//assert null if not found?
	            		element=elementsClass.findElementInList(elements,Parameter);
	            		
	            		//perform action
	            		elementsClass.performActionOnElement(null,null,element,Keyword,null,null,null,null,null,null);
	            		
	            		//assert whether correct element was clicked by checking the title of the page opened
	            		
	            	}	            	
	            	else
	            	{
	            		element = elementsClass.findElementOnPage(webdriver,objectRepo,Keyword, ElementLocatorType, UIElement,propertyFilePath,object);
	            		//check whether the javascript flag was set.If set, action will have to be performed via javascript and not webdriver
	            			if(objectRepo.getProperty("jsFlag").toString().compareTo("true")==0) 
	            			{
	            				System.out.println(UIElement+": User action on this element will be executed by JavaScriptExecutor");
	            				jsexec = true;
	            			}
	            			else
	            			{
	            				System.out.println(UIElement+": User action on this element will be executed by Webdriver");
	            				jsexec = false;
	            			}
	            		elementsClass.performActionOnElement(webdriver,propertyFilePath,element,Keyword,Parameter,jsexec,objectRepo,UIElement,ElementLocatorType,object);
	            		object.resetJSFlag(propertyFilePath,"jsFlag","false");
	            		
	            		//elementsClass.closeBrowserPage(webdriver);
	            	}
	    }
	    }    
	           else
	           	{
	           		//New testcase:check runFlag status and inform the user
	           		RunFlag=new String(row.getCell(5).toString());
	           		if (RunFlag.compareTo("N")==0)
	           			System.out.println("New Testcase->"+row.getCell(0).toString() +" Not run");
	           		else
	           		//Print the new testcase name when it started
	               	System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
	           	}
	
}
  }
}
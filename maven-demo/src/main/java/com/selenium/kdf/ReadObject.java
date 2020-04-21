package com.selenium.kdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ReadObject {
    Properties p = new Properties();
    FileOutputStream out;
    public Properties getObjectRepository() throws IOException{
        //Read object repository file
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\objects\\objects.properties"));
        //load all objects
        p.load(stream);
         return p;
    }
    
    public void setJSFlag(String propertyFilePath,String key, String Value) {
    	 try {
				out = new FileOutputStream(propertyFilePath);				
				getObjectRepository().setProperty(key, Value);
				getObjectRepository().store(out, "jsflag:Perform action on Element via Javascript has been set");
				out.close();
			 }
			catch(Exception f) {System.out.println("From setJSFlag():Unable to set JSFlag in properties file");}
    }
    
    public void resetJSFlag(String propertyFilePath,String key, String Value) {
   	 try {
				out = new FileOutputStream(propertyFilePath);				
				getObjectRepository().setProperty(key, Value);
				getObjectRepository().store(out, "jsflag:Perform action on Element via Javascript has been reset");
				out.close();
			 }
			catch(Exception f) {System.out.println("From setJSFlag():Unable to reset JSFlag in properties file");}
   }
    
  
}
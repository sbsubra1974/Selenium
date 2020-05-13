package com.selenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPFileTransfer {

	 //String server = "www.myserver.com";
     //int port = 21;
     String user = "user";
     String pass = "pass";
     FTPClient ftpClient = new FTPClient();
     
     public void ftpFileTransfer(String server, int port, String localFilePath,String remoteFileName) {
     
    	 try {

    		 System.out.println("here");
    		 ftpClient.connect(server, port);
    		 System.out.println("here");
         //ftpClient.login(user, pass);
         ftpClient.enterLocalPassiveMode();

         ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

         
         // APPROACH #1: uploads first file using an InputStream
         File firstLocalFile = new File(localFilePath);

         String firstRemoteFile = new String(remoteFileName);
         InputStream inputStream = new FileInputStream(firstLocalFile);

         System.out.println("Start uploading first file");
         boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
         inputStream.close();
         if (done) {
             System.out.println("The first file is uploaded successfully.");
         }

         
     } catch (IOException ex) {
         System.out.println("Error: " + ex.getMessage());
         ex.printStackTrace();
     } finally {
         try {
             if (ftpClient.isConnected()) {
                 ftpClient.logout();
                 ftpClient.disconnect();
             }
         } catch (IOException ex) {
             ex.printStackTrace();
         }
     }
 }

}

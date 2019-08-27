package com.group2.package1;

import java.io.File;

public class FileNameWithoutExtension {
	/* public static void main(String[] args) {
	        String fileName = getFileNameWithoutExtension(new File("C:\\article\\mongodb-json.zip"));
	        System.out.println("File Name :- " + fileName);
	        fileName = getFileNameWithoutExtension(new File("C:\\article\\eclipse.png"));
	        System.out.println("File Name :- " + fileName);
	    } */
	 
	    
		 static String getFileNameWithoutExtension(File file) {
	        String fileName = "";
	 
	        try {
	            if (file != null && file.exists()) {
	                String name = file.getName();
	                fileName = name.replaceFirst("[.][^.]+$", "");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            fileName = "";
	        }
	 
	        return fileName;
	 
	    }
}

package com.group2.package1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;


public class Decryption {
	void checkPathExistence(String a, String b) throws FileNotFoundException, IOException{
		File src = new File(a); // a = src_Path
        File dest = new File(b); // b = dest_Path
        if (!src.exists())
        {
            System.out.println("Source path does not exist.");
            JOptionPane.showMessageDialog(null, "Source path does not exist.");
        }
        else
        {
            // invoke makeDestinationDirectory method
        	 makeDestinationDirectory(src, dest);
        	 checkDirOrFile(src, dest);
        }

	}
	
	void makeDestinationDirectory(File src_file, File dest_file) { /* File src = srcDir , File dest = destDir  */
		if (src_file.isDirectory()) {
			if (!dest_file.exists())
            {
				dest_file.mkdir();
                System.out.println("Directory copied from " + src_file + "  to "
                        + dest_file);                	                	                
                
            }
		} 
	}
	
	void checkDirOrFile(File src_file, File dest_file) throws IOException {  /*File src = srcDir , File dest = destDir */
		
		if(src_file.isDirectory()) { //It is a directory
		 String files[] = src_file.list();
         for (String fileName : files)
          {
            // construct file structure
            File srcFile = new File(src_file, fileName);
            File destFile = new File(dest_file, fileName);
            if(srcFile.isDirectory()) {
            	  makeDestinationDirectory(srcFile, destFile);
            	  checkDirOrFile(srcFile,destFile);
            	  continue;
            }
            fileCopy(srcFile,destFile);
            System.out.println("File copied from " + src_file + " to " + dest_file);
        }
	}
		else{ //It is a file
			fileCopyForDirectFileOnly(src_file,dest_file);
			 System.out.println("File copied from " + src_file + " to " + dest_file);
		}
		
	}
	
	

	@SuppressWarnings("resource")
	void fileCopy(File src_file, File dest_file) throws IOException { /*File src = srcDir , File dest = destDir */
		InputStream is = null;
		OutputStream os = null;

		try
		{
			is = new FileInputStream(src_file);

			byte[] buffer = new byte[1024];

			byte[] name = new byte[is.read() * 2];
			is.read(name);
			//String fileName = bytesToString(name);
			
			StringBuilder sb = new StringBuilder(dest_file.getPath());
			StringBuilder sb1;
			sb1 = sb.delete((sb.length()-67), (sb.length()));
			String OriginalPath = sb1.toString();
			

			os = new FileOutputStream(OriginalPath);
			System.out.println();

			int length;

			while ((length = is.read(buffer)) > 0)
			{
				decryptBytes(buffer);
				os.write(buffer, 0, length);
			}

		} finally
		{
			/*is.close();
			os.close();*/
		}

	
	}
	
	@SuppressWarnings("resource")
	void fileCopyForDirectFileOnly(File src_file, File dest_file) throws IOException { /*File src = srcDir , File dest = destDir */
		InputStream is = null;
		OutputStream os = null;
		 dest_file.mkdir();

		try
		{
			is = new FileInputStream(src_file);

			byte[] buffer = new byte[1024];

			byte[] name = new byte[is.read() * 2];
			is.read(name);
			//String fileName = bytesToString(name);
			
			StringBuilder sb = new StringBuilder(src_file.getName());
			StringBuilder sb1;
			sb1 = sb.delete((sb.length()-67), (sb.length()));
			String OriginalPath = sb1.toString();
			
			dest_file = new File(dest_file.getPath().concat("/").concat(OriginalPath));

			os = new FileOutputStream(dest_file);
		

			int length;

			while ((length = is.read(buffer)) > 0)
			{
				decryptBytes(buffer);
				os.write(buffer, 0, length);
			}

		} finally
		{
			/*is.close();
			os.close();*/
		}

	
	}
	
	public String bytesToString(byte[] data)
	{
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < data.length / 2; i++)
		{
			char c = (char) ((data[i * 2] << 8) | data[i * 2 + 1]);
			res.append(c);
		}

		return res.toString();
	}

	private void decryptBytes(byte[] data) // Decryption Algorithm is written into here
	{
		for (int i = 0; i < data.length; i++)
		{
			data[i] = (byte) ~data[i];
		}
	}
	
	

}

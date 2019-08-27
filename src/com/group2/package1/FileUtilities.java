package com.group2.package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public abstract class FileUtilities {
	void checkPathExistence(String srcPath, String destPath) throws FileNotFoundException, IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if (!src.exists()) {
			System.out.println("Source path does not exist.");
			JOptionPane.showMessageDialog(null, "Source path does not exist.");
		} else {
			// invoke makeDestinationDirectory method
			makeDestinationDirectory(src, dest);
			checkDirOrFile(src, dest);
		}

	}

	void makeDestinationDirectory(File srcFile, File destFile) {
		if (srcFile.isDirectory()) {
			if (!destFile.exists()) {
				destFile.mkdir();
				
				System.out.println("Directory copied from " + srcFile + "  to " + destFile);

			}
		}
	}

	void checkDirOrFile(File srcFile, File destFile) {
		if (srcFile.isDirectory()) { // It is a directory
			String files[] = srcFile.list();
			for (String fileName : files) {
				// construct file structure
				File srcFile1 = new File(srcFile, fileName);
				File destFile1 = new File(destFile, fileName);
				if (srcFile1.isDirectory()) {
					makeDestinationDirectory(srcFile1, destFile1);
					checkDirOrFile(srcFile1, destFile1);
					continue;
				}
				fileCopy(srcFile1, destFile1);
				System.out.println("File copied from " + srcFile1 + " to " + destFile1);
			}
		} else { // It is a file
			fileCopyForDirectFileOnly(srcFile, destFile);
			System.out.println("File copied from " + srcFile + " to " + destFile);
		}

	}

	abstract void fileCopy(File srcFile, File destFile);

	abstract void fileCopyForDirectFileOnly(File srcFile, File destFile);

}

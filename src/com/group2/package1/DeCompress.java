package com.group2.package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class DeCompress extends FileUtilities {
	@Override
	void fileCopy(File src_file, File dest_file) {

		StringBuilder sb = new StringBuilder(dest_file.getPath());
		StringBuilder sb1;
		sb1 = sb.delete((sb.length() - 66), (sb.length()));
		String OriginalPath = sb1.toString();

		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		FileOutputStream fos = null;
		GZIPInputStream gzis = null;
		try {
			fis = new FileInputStream(src_file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			gzis = new GZIPInputStream(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fos = new FileOutputStream(OriginalPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int read;
		try {
			while ((read = gzis.read(buffer)) != -1) {
				fos.write(buffer, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			gzis.close();
			;
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	void fileCopyForDirectFileOnly(File src_file, File dest_file) {

		dest_file.mkdir();

		StringBuilder sb = new StringBuilder(src_file.getName());
		StringBuilder sb1;
		sb1 = sb.delete((sb.length() - 66), (sb.length()));
		String OriginalPath = sb1.toString();

		dest_file = new File(dest_file.getPath().concat("/").concat(OriginalPath));

		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		GZIPInputStream gzis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src_file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			gzis = new GZIPInputStream(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			fos = new FileOutputStream(dest_file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int read;
		try {
			while ((read = gzis.read(buffer)) != -1) {
				try {
					fos.write(buffer, 0, read);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			gzis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

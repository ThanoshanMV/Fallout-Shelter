package com.group2.package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class Encryption extends FileUtilities {
	@Override
	void fileCopy(File srcFile, File destFile) {
		InputStream is = null;
		OutputStream os = null;

		destFile = new File(destFile.getPath().concat(RandomName.getRandomName(50, "fallout_Premiere")));
		// fallout_Express

		try {
			is = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			os = new FileOutputStream(destFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			os.write(new byte[] { (byte) srcFile.getName().length() });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			os.write(stringToByte(srcFile.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] buffer = new byte[1024];

		int length;

		try {
			while ((length = is.read(buffer)) > 0) {
				encryptBytes(buffer);
				os.write(buffer, 0, length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	void fileCopyForDirectFileOnly(File srcFile, File destFile) {
		InputStream is = null;
		OutputStream os = null;
		destFile.mkdir();
		destFile = new File(destFile.getPath().concat("/").concat(srcFile.getName())
				.concat(RandomName.getRandomName(50, "fallout_Premiere")));

		try {
			is = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			os = new FileOutputStream(destFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			os.write(new byte[] { (byte) srcFile.getName().length() });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			os.write(stringToByte(srcFile.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] buffer = new byte[1024];

		int length;

		try {
			while ((length = is.read(buffer)) > 0) {
				encryptBytes(buffer);
				os.write(buffer, 0, length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void encryptBytes(byte[] data) // Encryption Algorithm is written into here
	{
		for (int i = 0; i < data.length; i++) {
			data[i] = (byte) ~data[i];
		}
	}

	public byte[] stringToByte(String data) {
		char[] ca = data.toCharArray();
		byte[] res = new byte[ca.length * 2]; // Character.BYTES = 2;

		for (int i = 0; i < res.length; i++) {
			res[i] = (byte) ((ca[i / 2] >> (8 - (i % 2) * 8)) & 0xff);
		}

		return res;
	}

}

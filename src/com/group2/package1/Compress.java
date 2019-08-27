package com.group2.package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;



public class Compress extends FileUtilities {
	@Override
	void fileCopy(File src_file, File dest_file) {
		dest_file = new File(dest_file.getPath().concat(RandomName.getRandomName(50, "fallout_Express")));
		byte[] buffer = new byte[1024];
			FileInputStream fis = null;
			FileOutputStream fos = null;
			GZIPOutputStream gzos = null;
			try {
				fis = new FileInputStream(src_file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fos = new FileOutputStream(dest_file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				gzos = new GZIPOutputStream(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int read;
			try {
				while ((read = fis.read(buffer)) != -1) {
					gzos.write(buffer, 0, read);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				gzos.finish();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				gzos.close();
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
	


	@Override
	void fileCopyForDirectFileOnly(File srcFile, File destFile) {
		destFile.mkdir();
		destFile = new File(destFile.getPath().concat("/").concat(srcFile.getName())
				.concat(RandomName.getRandomName(50, "fallout_Express")));
		StaticFields.sourcePathOfBackupToZip = destFile.getAbsolutePath();
		StaticFields.fileName = FileNameWithoutExtension.getFileNameWithoutExtension(srcFile);
		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(destFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GZIPOutputStream gzos = null;
		try {
			gzos = new GZIPOutputStream(fos);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int read;
		try {
			while ((read = fis.read(buffer)) != -1) {
				gzos.write(buffer, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			gzos.finish();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			gzos.close();
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

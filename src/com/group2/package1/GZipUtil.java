package com.group2.package1;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public class GZipUtil {

	public static boolean isGZipped(File f) { // Checking whether the file is gzipped or not.
		int magic = 0;
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			magic = raf.read() & 0xff | ((raf.read() << 8) & 0xff00);
			raf.close();
		} catch (Throwable e) {
			e.printStackTrace(System.err);
		}
		return magic == GZIPInputStream.GZIP_MAGIC;
	}

}

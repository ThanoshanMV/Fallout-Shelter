package com.group2.package1;

import java.util.Random;

public class RandomName {
	public static String getRandomName(int length, String extend) {
		Random r = new Random();
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < length; i++) {

			char c = 'a';
			int width = 'z' - 'a';

			if (r.nextInt(3) == 0) {
				c = 'A';
				width = 'Z' - 'A';
			}
			if (r.nextInt(3) == 1) {
				c = '0';
				width = '9' - '0';
			}

			res.append((char) (c + r.nextInt(width)));
		}

		res.append(".").append(extend);

		return res.toString();
	}
}

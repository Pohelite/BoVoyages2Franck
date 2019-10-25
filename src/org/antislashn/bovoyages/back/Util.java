package org.antislashn.bovoyages.back;

public class Util {
	public static boolean isLong(String i) {
		try {
			Long.parseLong(i);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}

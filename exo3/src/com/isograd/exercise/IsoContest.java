/*******
 * Read input from System.in
 * Use System.out.println to ouput your result.
 * Use:
 *  IsoContestBase.localEcho( variable)
 * to display variable in a dedicated area.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {

public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
			line = sc.nextLine();
			System.out.println(isValid(line)? "OK" :"KO");
		}
    }

	private static final int MIN_CHAR_VALUE = 97;
	private static boolean isValid(String line) {
		String[] split = line.split(" ");
		String codeBanque = convert(split[0]);
		String codeguichet  = convert(split[1]);
		String numerodecompte = convert(split[2]);
		long sum = 89 * Long.parseLong(codeBanque)
				+ 15 * Long.parseLong(codeguichet)
				+ 3 * Long.parseLong(numerodecompte);
		
		return Long.parseLong(split[3]) == 97 - (sum % 97);
	}
	
	private static String convert(String code) {
		StringBuilder converted = new StringBuilder();
		for (char c : code.toLowerCase().toCharArray()) {
			int val = getAscii(c);
			converted.append(val);
			System.out.println(String.valueOf(c) + " " +val);
		}
		return converted.toString();
	}
	
	private static int getAscii(char c) {
		if (c >= 'a' && c < 's') { 
			return ((((int)c) - MIN_CHAR_VALUE) % 9)+1;
		} else if (c >= 's') {
			return ((((int)c) - MIN_CHAR_VALUE) % 9)+2;
		} else {
			return Integer.parseInt(String.valueOf(c));
		}
	}
}
/* 
 * DO NOT PASTE THIS UTILITY CODE BACK INTO THE BROWSER WINDOW
 */

class IsoContestBase {
	public static void localEcho( String txt ) {
		System.err.println( txt );
	}
}
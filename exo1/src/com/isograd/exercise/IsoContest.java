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
        String line = null;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
        	line = sc.nextLine();
		}
        List<String> split = Arrays.asList(line.split(" "));
        List<String> colors = Arrays.asList("C", "P", "Q", "T");
        List<String> values = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "V", "D", "R", "A");
        StringBuilder missingCards = new StringBuilder();
        for (String color : colors) {
        	for (String value : values) {
        		String card = color + value;
        		if (!split.contains(card)) {
        			missingCards.append(card + " ");
        		}
        	}
        }
        System.out.println(missingCards.toString().trim());
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
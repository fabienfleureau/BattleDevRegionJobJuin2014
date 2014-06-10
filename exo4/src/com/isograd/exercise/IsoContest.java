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
        Map<String, List<String>> nodes = new HashMap<String, List<String>>();
        String firstNode = null;
        while(sc.hasNextLine()) {
			line = sc.nextLine();
			List<String> split = Arrays.asList(line.split(" "));
			if (firstNode == null) {
				firstNode = split.get(0);
			}
			nodes.put(split.get(0), split.subList(1, split.size()));
		}
        System.out.println(calculateMax(nodes, firstNode));
        
    }

	public static int calculateMax(Map<String, List<String>> nodes, String currentNode) {
		if (nodes.get(currentNode) == null) {
			return 0;
		}
		int max = 0;
		for (String nextNode : nodes.get(currentNode)) {
			int maybeMax = calculateMax(nodes, nextNode);
			if (maybeMax > max) {
				max = maybeMax;
			}
		}
		return max + 1;
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
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
        Map<String, List<String>> linked = new HashMap<String, List<String>>();
        Map<String, List<String>> notLinked = new HashMap<String, List<String>>();
        String start = null;
		int distance = 0;
        while(sc.hasNextLine()) {
			line = sc.nextLine();
			if (line.contains(" + ")) {
				String[] split = line.split(" \\+ ");
				List<String> targets = linked.get(split[0]);
				if (targets == null ) {
					targets = new ArrayList<String>();
					linked.put(split[0], targets);
				}
				targets.add(split[1]);
			} else if (line.contains(" - ")) {
				String[] split = line.split(" \\- ");
				List<String> targets = notLinked.get(split[0]);
				if (targets == null ) {
					targets = new ArrayList<String>();
					notLinked.put(split[0], targets);
				}
				targets.add(split[1]);
			} else {
				String[] split = line.split(" \\? ");
				start = split[0];
				distance = Integer.parseInt(split[1]);
			}
		}
        List<String> accessibles = new ArrayList<String>(accessibles(start, distance, linked, notLinked));
        if (notLinked.get(start) != null) {
        	for (String target : notLinked.get(start)) {
        		accessibles.remove(target);
        	}
        }
        StringBuilder targets = new StringBuilder();
        Collections.sort(accessibles);
        for (String target : accessibles) {
        	targets.append(target + " ");
        }
        System.out.println(targets.toString().trim());
    }

	public static HashSet<String> accessibles(String current, int distance, Map<String, List<String>> linked, Map<String, List<String>> notLinked) {
		HashSet<String> accessibles = new HashSet<String>();
		accessibles.add(current);
		if (distance != 0) {
			List<String> targets = linked.get(current);
			if (targets != null) {
				for (String target : targets) {
					HashSet<String> accessibles2 = accessibles(target, distance-1, linked, notLinked);
					if (notLinked.get(target) != null) {
			        	for (String notTarget : notLinked.get(target)) {
			        		accessibles2.remove(notTarget);
			        	}
			        }
					accessibles.addAll(accessibles2);
				}
			}
		}
		return accessibles;
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
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
        List<String> posXAsString = new ArrayList<>();
        List<String> posYAsString = new ArrayList<>();
        List<String> timeAsString = new ArrayList<>();
        while(sc.hasNextLine()) {
			line = sc.nextLine();
			String[] split = line.split(" ");
			posXAsString.add(split[0]);
			posYAsString.add(split[1]);
			timeAsString.add(split[2]);
		}
        double currentPosX = Integer.parseInt(posXAsString.get(0));
        double currentPosY = Integer.parseInt(posYAsString.get(0));
        double distance = 0;
        for (int i = 1 ; i < posXAsString.size() ; i++) {
        	double newPosX = Integer.parseInt(posXAsString.get(i));
        	double newPosY = Integer.parseInt(posYAsString.get(i));
        	distance += Math.sqrt(((newPosX - currentPosX)*(newPosX - currentPosX) + (newPosY - currentPosY)*(newPosY - currentPosY)));
        	currentPosX = newPosX;
        	currentPosY = newPosY;
        }
        
        String[] startTimeSplit = timeAsString.get(0).split(":");
        String[] endTimeSplit = timeAsString.get(timeAsString.size()-1).split(":");
        int startTime = Integer.parseInt(startTimeSplit[0])*60*60 + Integer.parseInt(startTimeSplit[1])*60 + Integer.parseInt(startTimeSplit[2]);
        int endTime = Integer.parseInt(endTimeSplit[0])*60*60 + Integer.parseInt(endTimeSplit[1])*60 + Integer.parseInt(endTimeSplit[2]);
        double value = (distance/1000 / ((endTime - startTime)/3600));
        System.out.println((double)Math.round(value*100)/100);
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
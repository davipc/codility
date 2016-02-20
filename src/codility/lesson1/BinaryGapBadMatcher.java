package codility.lesson1;

import java.util.*;
import java.util.regex.*;

public class BinaryGapBadMatcher {

    public int solution(int N) {
        String binStr = Integer.toBinaryString(N);

        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("10+1").matcher(binStr);
        
        while (m.find()) {
            allMatches.add(m.group());
        }
        
        int maxSize = 0;
        for (String match: allMatches) {
        	System.out.println("Match: " + match);
            // need to subtract 2 from size since match includes the surrounding 1's
            if (match.length()-2 > maxSize) {
                maxSize = match.length()-2;
            }
        }

        System.out.println(N + " -> binary string: " + binStr + "; size: " + maxSize);
        
        return maxSize;
    }
	
    
    public static void main(String[] args) {
    	
    	BinaryGapBadMatcher bg = new BinaryGapBadMatcher();
    	
    	bg.solution(328);
    	bg.solution(1162);
    	
	}
}

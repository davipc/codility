package codility.lesson10;

import java.util.*;

public class FlagsONxK {

    public int solution(int[] A) {
        int result = 0;
        
        int N = A.length;
        
        // build array of peak positions
        ArrayList<Integer> peaks = new ArrayList<Integer>();
        for (int i = 1; i < N-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1])
                peaks.add(i);
        }
        
        if (peaks.size() <= 1) {
            result = peaks.size();
        } else {
            // check for each number of flags if we can place that number of flags
            // from top to bottom, so we can stop when we find the higher
            int matched;
            int lastMatched;
            for (int numFlags = peaks.size(); numFlags >= 1; numFlags--) {
                //System.out.println("Checking numFlags = " + numFlags + "...");
                matched = 0;
                lastMatched = -500000;
                for (int peak: peaks) {
                    //System.out.print("Checking " + peak + " with " + lastMatched + ": ");
                    if ((peak - lastMatched) >= numFlags) {
                        matched++;
                        lastMatched = peak;
                        // stop looking if we already spent all flags
                        if (matched == numFlags) {
                        	break;
                        }
                        //System.out.println("matched!");
                    } else {
                        //System.out.println("did not match");
                    }
                }
                // if all flags could be placed, consider this number
                if (numFlags == matched) {
                    result = numFlags;
                    break;
                }
                //System.out.println();
                
            }
        }

        System.out.println(Arrays.toString(A) + " => " + result);
            
        return result;
    }

    public static void main(String[] args) {
		FlagsONxK f = new FlagsONxK();
		f.solution(new int[]{1});
		f.solution(new int[]{1,1});
		f.solution(new int[]{1,2});
		f.solution(new int[]{1,2,2});
		f.solution(new int[]{1,3,2});
		f.solution(new int[]{1,3,2});
		f.solution(new int[]{1,2,3,4,5,6,7,8});
		f.solution(new int[]{1,2,1,2,1,2,1});
		f.solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2});
	}

}

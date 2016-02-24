package codility.lesson10;

import java.util.*;

public class Flags {

    public int solution(int[] A) {
        int result = 0;
        
        int N = A.length;
        
        System.out.println(Arrays.toString(A));
        
        // mark peaks
        int count = 0;
        int[] peaks = new int[N];
        for (int i = 1; i < N-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks[i] = 1;
                count++;
            }
        }

        if (count <= 1) {
        	result = count;
        } else {
        
	        // build array of next peak positions
	        int[] nextPeakPos = new int[N];
	        int lastPeakFound = -1;
	        for (int i = N-1; i >= 0; i--) {
	        	nextPeakPos[i] = lastPeakFound;
	        	if (peaks[i] == 1) {
	        		lastPeakFound = i;
	        	}
	        }

	        System.out.println("Next positions: " + Arrays.toString(nextPeakPos));
	        
            // check for each number of flags if we can place that number of flags
            // from top to bottom, so we can stop when we find the higher
            int matched;
            int nextPeak;
            int nextIdx;
            for (int numFlags = count; numFlags >= 1; numFlags--) {
                System.out.println("Checking numFlags = " + numFlags + "...");
                matched = 0;
                nextPeak = nextPeakPos[0]; // position at first found peak
                while (nextPeak < N && nextPeak != -1) {
                    System.out.print("Adding " + nextPeak + ": ");
                    matched++;
                    
                    // find the idx of the next valid peak (valid if distance >= numFlags)
                	nextIdx = nextPeak + numFlags - 1;
                	if (nextIdx < N && nextIdx != -1) {
                		nextPeak = nextPeakPos[nextIdx];
                	} else {
                		System.out.println(" array Finished before flags");
                		break;
                	}

                	// also stop looking if we already spent all flags
                    if (matched == numFlags) {
                    	System.out.println("flags finished");
                    	break;
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

        System.out.println("Result => " + result);
            
        return result;
    }

    public static void main(String[] args) {
		Flags f = new Flags();
		/**
		f.solution(new int[]{1});
		f.solution(new int[]{1,1});
		f.solution(new int[]{1,2});
		f.solution(new int[]{1,2,2});
		f.solution(new int[]{1,3,2});
		f.solution(new int[]{1,3,2});
		f.solution(new int[]{1,2,3,4,5,6,7,8});
		**/
		f.solution(new int[]{1,2,1,2,1,2,1});
		//f.solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2});
	}

}

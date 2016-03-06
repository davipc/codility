package codility.lesson10;

import java.util.*;


/**
 * 
A non-empty zero-indexed array A consisting of N integers is given.

A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
has exactly four peaks: elements 1, 3, 5 and 10.

You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. 
You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.



Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. 
The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:

two flags, you can set them on peaks 1 and 5;
three flags, you can set them on peaks 1, 5 and 10;
four flags, you can set only three flags, on peaks 1, 5 and 10.
You can therefore set a maximum of three flags in this case.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
the function should return 3, as explained above.

Assume that:

N is an integer within the range [1..400,000];
each element of array A is an integer within the range [0..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
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
            	// (note: could also stop if matched == numFlags-1, as there would be no point in iterating with 
            	// numFlags-1:  max result would still be numFlags-1) 
                if (matched >= numFlags -1) {
                    result = matched;
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

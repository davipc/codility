package codility.lesson8;

import java.util.Arrays;

/**
 * 
A zero-indexed array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

A[0] = 3    A[1] = 4    A[2] =  3
A[3] = 2    A[4] = 3    A[5] = -1
A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given a zero-indexed array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. 
The function should return −1 if array A does not have a dominator.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
For example, given array A such that

A[0] = 3    A[1] = 4    A[2] =  3
A[3] = 2    A[4] = 3    A[5] = -1
A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 * 
 * 
 * @author Davi
 *
 */
public class Dominator {
    public int solution(int[] A) {
        int result = -1;

        // given required space complexity, cannot use a stack or a copy of input array
        // given required result (index) and space complexity (can't copy input array), cannot sort the input array

        if (A.length > 0) {
            int candidate = A[0];
            int candidateCount = 1;
            
            for (int i = 1; i < A.length; i++) {
                if (A[i] == candidate) {
                    candidateCount++;
                } else {
                    candidateCount--;
                    if (candidateCount == 0) {
                        candidate = A[i];
                        candidateCount = 1;
                    }
                }
            }
            
            // if any candidates left at the end, check if it dominates the array
            if (candidateCount > 0) {
                int finalCount = 0;
                int position = -1;
                for (int i = 0; i < A.length; i++) {
                    if (candidate == A[i]) {
                        finalCount++;
                        position = i;
                    }
                }
                
                if (finalCount > A.length / 2) {
                    result = position;
                }
            }
        }
        
        System.out.println(Arrays.toString(A) + " => " + result);
        return result;
    }
    
    public int solution2(int[] A) {
    	int result = -1;

    	int N = A.length;
    	
    	if (N > 0) {
	    	int candidate = A[0];
	    	int count = 1;
    	
	    	for (int i = 1; i < N; i++) {
	    		if (count > 0) {
	    			if (A[i] == candidate)
	    				count++;
	    			else 
	    				count--;
	    		} else {
	    			count = 1;
	    			candidate = A[i];
	    		}
	    		
	    	}
	    	
	    	if (count > 0) {
	    		// now check if the candidate is really a dominator
	    		int idx = -1;
	    		count = 0;
	    		for (int i = N-1; i >= 0; i--)
	    			if (A[i] == candidate) {
	    				count++;
	    				idx = i;
	    			}
	    		
	    		if (count > N/2)
	    			result = idx;
	    	}
    	}
    	
    	System.out.println(Arrays.toString(A) + " => " + result);
    	
    	return result;
    }
    
    private static void checkEqual(int i1, int i2) {
    	if (i1 == i2)
    		System.out.println("equal");
    	else System.out.println("not equal");
    	
    }
    
    
    public static void main(String[] args) {
		Dominator d = new Dominator();
		
		checkEqual(d.solution(new int[]{}), d.solution2(new int[]{}));
		checkEqual(d.solution(new int[]{1}), d.solution2(new int[]{1}));
		checkEqual(d.solution(new int[]{1,2}), d.solution2(new int[]{1,2}));
		checkEqual(d.solution(new int[]{1,2,1}), d.solution2(new int[]{1,2,1}));
		checkEqual(d.solution(new int[]{0,0}), d.solution2(new int[]{0,0}));
		checkEqual(d.solution(new int[]{3,4,3,2,3,-1,3,3}), d.solution2(new int[]{3,4,3,2,3,-1,3,3}));
	}
}

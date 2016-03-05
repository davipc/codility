package codility.lesson9;

import java.util.Arrays;

/**
 * 
A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. 
The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

For example, given array A such that:

A[0] = 3  A[1] = 2  A[2] = -6
A[3] = 4  A[4] = 0
the function should return 5 because:

(3, 4) is a slice of A that has sum 4,
(2, 2) is a slice of A that has sum −6,
(0, 1) is a slice of A that has sum 5,
no other slice of A has sum greater than (0, 1).
Assume that:

N is an integer within the range [1..1,000,000];
each element of array A is an integer within the range [−1,000,000..1,000,000];
the result will be an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
public class MaxSliceSum {
	public int solution(int[] A) {
        long maxEnding = Integer.MIN_VALUE;
        long maxSliceSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            maxEnding = Math.max((long)maxEnding + (long)A[i], A[i]);
            maxSliceSum = Math.max(maxSliceSum, maxEnding);
            //System.out.println("A[" + i + "] => " + maxEnding + ", " + maxSliceSum);
        }
        
        System.out.println(Arrays.toString(A) + " => " + maxSliceSum);
        
        return (int) maxSliceSum;
    }
    
    public static void main(String[] args) {
		MaxSliceSum mss = new MaxSliceSum();
		
		mss.solution(new int[]{1});
		mss.solution(new int[]{-3,-2,-1,-1,-1});
		mss.solution(new int[]{-2,-3,-1,5,-1,2});
		mss.solution(new int[]{0,2,1,7});
		mss.solution(new int[]{-2147483648, -1});
		mss.solution(new int[]{2147483647, 1});
		mss.solution(new int[]{-2147483648, -2147483648, -2147483648, 0});
		mss.solution(new int[]{-2147483648, -2147483648, -2147483648});
	}
}

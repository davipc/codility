package codility.lesson15;

import java.util.Arrays;

/**
 * 
Let A be a non-empty zero-indexed array consisting of N integers.

The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.

For example, the following array A:

  A[0] =  1
  A[1] =  4
  A[2] = -3
has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2). 
The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2. 
The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5. 
The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2. 
The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8. 
The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1. 
The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6. 
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A consisting of N integers, returns the minimal abs sum of two for any pair of indices in this array.

For example, given the following array A:

  A[0] =  1
  A[1] =  4
  A[2] = -3
the function should return 1, as explained above.

Given array A:

  A[0] = -8
  A[1] =  4
  A[2] =  5
  A[3] =-10
  A[4] =  3
the function should return |(−8) + 5| = 3.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
public class MinAbsSumOfTwo {
	public int solution(int[] A) {
        int result = Integer.MAX_VALUE;
        
        int N = A.length;
        
        Arrays.sort(A);
        
        // if all positives, just take 2 x smallest
        if (A[0] >= 0) {
            result = 2 * A[0];
        } else 
        // if all negative, just take -2 x highest
        if (A[N-1] <= 0) {
            result = -2 * A[N-1];   
        }
        // if mix, go from extremes to middle to find smaller
        else {
            int left, right;
            left = 0;
            right = N-1;
            
            int min = Math.abs(A[left] + A[right]);
            while (left < right) {
                if (Math.abs(A[left+1] + A[right]) < Math.abs(A[left] + A[right-1]))
                    left++;
                else 
                    right--;
                
                // last calculation should be when left == right
                min = Math.min(min, Math.abs(A[left] + A[right]));
            }
            
            result = min;
        }
        
        System.out.println(Arrays.toString(A) + " => " + result);
        
        return result;
    }
	
	public static void main(String[] args) {
		MinAbsSumOfTwo min = new MinAbsSumOfTwo();
		
		min.solution(new int[]{-5});
		min.solution(new int[]{0});
		min.solution(new int[]{2});
		min.solution(new int[]{-5,-4,-1});
		min.solution(new int[]{-5,-4,-1, 0});
		min.solution(new int[]{5,4,3});
		min.solution(new int[]{5,4,3,0});
		min.solution(new int[]{-5, 4});
		min.solution(new int[]{-5, -4, 2, 3});
		min.solution(new int[]{8,7,6,5,4,-1,-9,-10});
		min.solution(new int[]{1,4,-3});
		min.solution(new int[]{-8,4,5,-10,3});
		min.solution(new int[]{-99, -50, -40, -30, 20, 60, 98});
	}
}

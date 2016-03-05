package codility.lesson4;

import java.util.*;

/**
 * 
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.

The sequence should be returned as:

a structure Results (in C), or
a vector of integers (in C++), or
a record Results (in Pascal), or
an array of integers (in any other programming language).
For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Assume that:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
Complexity:

expected worst-case time complexity is O(N+M);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
public class MaxCounters {
	public int[] solution(int N, int[] A) {
        int[] positions = new int[N];
        
        String arrayStr = Arrays.toString(A);
        
        Arrays.fill(positions, 0);
        
        int maxValue = 0;
        // have to use the lowBar (instead of updating array elements) in order to achieve O(N+M)
        int lowBar = 0;
        int value;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                lowBar = maxValue;
            } else {
            	// first check if this counter's value is below the low bar
                value = positions[A[i]-1];
                if (value < lowBar)
                	value = lowBar+1;
                else 
                	value++;
                
                positions[A[i]-1] = value;
                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }
        
        // finally set the low bar to the counters with value still below it
        for (int i = 0; i < positions.length; i++) {
        	if (positions[i] < lowBar) {
        		positions[i] = lowBar;
        	}
        }
        
        System.out.println("(" + N + ", " + arrayStr + ") => " + Arrays.toString(positions));
        
        return positions;
    }    
    
	public static void main(String[] args) {
    	MaxCounters mc = new MaxCounters();
    	
    	mc.solution(1, new int[]{2});
    	mc.solution(1, new int[]{1});
    	mc.solution(1, new int[]{2,1});
    	mc.solution(1, new int[]{1,2});
    	mc.solution(1, new int[]{2,2,2});
    	mc.solution(1, new int[]{1,1,1});
    	mc.solution(1, new int[]{1,2,1});
    	mc.solution(2, new int[]{3});
    	mc.solution(2, new int[]{2});
    	mc.solution(2, new int[]{1});
    	mc.solution(2, new int[]{1,3,1});
    	mc.solution(3, new int[]{1,2,1,1,1,1,1,4,3});
    	mc.solution(3, new int[]{2,3,4});
	}
}

package codility.lesson4;

import java.util.Arrays;

/**
 * 
A non-empty zero-indexed array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 * @author Davi
 *
 */

public class PermCheckONlogN {
	// you can also use imports, for example:

	public int solution(int[] A) {
		int result = 1;

        String arrayStr = Arrays.toString(A);
		
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				result = 0;
				break;
			}
		}

        System.out.println(arrayStr + " => " + result);
		
		return result;
	}
	
    public static void main(String[] args) {
		PermCheckONlogN pc = new PermCheckONlogN();
		
		pc.solution(new int[]{});
		pc.solution(new int[]{2});
		pc.solution(new int[]{2,1});
		pc.solution(new int[]{4,3,2});
		pc.solution(new int[]{2,3,4,5,1});
		pc.solution(new int[]{2,3,4,6,1});
	}

}

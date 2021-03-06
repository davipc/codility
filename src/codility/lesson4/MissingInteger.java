package codility.lesson4;

import java.util.*;

/**
 * 
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.

For example, given:

  A[0] = 1
  A[1] = 3
  A[2] = 6
  A[3] = 4
  A[4] = 1
  A[5] = 2
the function should return 5.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * 
 * @author Davi
 *
 */
public class MissingInteger {
	public int solution(int[] A) {
		int result = -1;

		int N = A.length;
		
		String arrayStr = Arrays.toString(A);

		boolean[] found = new boolean[N+1];
		
		// an array of size N should be enough... if there are any gaps, it's the gap. 
		// If not, the first missing number is N+1 (since the array can only take N elements)
		for (int a: A) {
			// only consider positive numbers up to N - all other numbers in A will not be needed for the solution  
			if (a > 0 && a <= N)
				found[a] = true;
		}
		

		for (int i = 1; i <= N; i++) {
			if (!found[i]) {
				result = i;
				break;
			}
		}
		
		// if no gaps were found, result is N+1
		if (result == -1) {
			result = N + 1;
		}
		
		System.out.println(arrayStr + " => " + result);
		
		return result;
	}
	
	public static void main(String[] args) {
		MissingInteger mi = new MissingInteger();
		
		mi.solution(new int[]{-12});
		mi.solution(new int[]{0});
		mi.solution(new int[]{1});
		mi.solution(new int[]{2});
		mi.solution(new int[]{-456, -786998});
		mi.solution(new int[]{1, 3});
		mi.solution(new int[]{1, 1});
		mi.solution(new int[]{2, 2});
		mi.solution(new int[]{2,-4526});
		mi.solution(new int[]{2,3});
		mi.solution(new int[]{3,2,1});
		mi.solution(new int[]{-4564,4,1,2,1,0});
	}
}

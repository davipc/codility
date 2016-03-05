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
public class MissingIntegerONlogN {
	public int solution(int[] A) {
		int result = -1;

		String arrayStr = Arrays.toString(A);
		
		TreeSet<Integer> orderedPositiveInt = new TreeSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				orderedPositiveInt.add(A[i]);
			}
		}

		// if there are no positive values, 1 is the answer
		if (orderedPositiveInt.isEmpty()) {
			result = 1;
		} else
		// if there are, the first positive number should always be 1
		// (requirement)
		if (orderedPositiveInt.first() != 1) {
			result = 1;
		} else {
			int previousNumber = 1;
			boolean found = false;
			for (Integer i : orderedPositiveInt) {
				// if a gap was found, return the gap value
				if (i != previousNumber && i > previousNumber + 1) {
					result = previousNumber + 1;
					found = true;
					break;
				}

				previousNumber = i;
			}

			// in case the array contains all numbers in order (no gaps), the
			// result is the last positive+1
			if (!found)
				result = previousNumber + 1;
		}
		
		System.out.println(arrayStr + " => " + result);
		
		return result;
	}
	
	public static void main(String[] args) {
		MissingIntegerONlogN mi = new MissingIntegerONlogN();
		
		mi.solution(new int[]{});
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

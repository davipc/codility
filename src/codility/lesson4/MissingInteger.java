package codility.lesson4;

import java.util.*;

public class MissingInteger {
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
		MissingInteger mi = new MissingInteger();
		
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

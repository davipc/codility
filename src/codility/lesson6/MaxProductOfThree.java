package codility.lesson6;

import java.util.*;

public class MaxProductOfThree {

	public int solution(int[] A) {
		int result;

		int N = A.length;

		String arrayStr = Arrays.toString(A);
		
		// first of all, sort the array
		Arrays.sort(A);

		// if arrays contains only 3 elements, return the multiplication
		if (N == 3) {
			result = A[0] * A[1] * A[2];
		} else {
			// if all numbers are negative or 0, top result will be the
			// multiplication of 3 last
			if (A[N - 1] <= 0) {
				result = A[N - 3] * A[N - 2] * A[N - 1];
			}
			// if all 0 or positive, higher positive will be the multiplication
			// of 3 last
			else if (A[0] >= 0) {
				result = A[N - 3] * A[N - 2] * A[N - 1];
			}
			// there's a mix of negatives, 0's and positives
			// first check if there are at least 2 negatives
			else if (A[1] < 0) {
				// check what multiplication is higher, the 2 "bigger" negatives
				// or the 2 bigger positives before last
				result = (A[0] * A[1] > A[N - 3] * A[N - 2]) ? A[0] * A[1] : A[N - 3] * A[N - 2];
				result *= A[N - 1];
			}
			// if there is only one negative, top result will be last 3
			// positives
			else {
				result = A[N - 3] * A[N - 2] * A[N - 1];
			}
		}

		System.out.println(arrayStr + " => " + result);
		
		return result;
	}
	
	public static void main(String[] args) {
		MaxProductOfThree mp3 = new MaxProductOfThree();
		
		mp3.solution(new int[]{5, 2, 4});
		mp3.solution(new int[]{-3, -1, -10});
		mp3.solution(new int[]{1, 0, -1});
		mp3.solution(new int[]{0, 0, 0, 0});
		mp3.solution(new int[]{-1, -4, -5, 0});
		mp3.solution(new int[]{-1, -10, -5, -2});
		mp3.solution(new int[]{10, 2, 0, 0});
		mp3.solution(new int[]{10, 0, 3, 4});
		mp3.solution(new int[]{-2, -5, 0, 8, 2});
		mp3.solution(new int[]{-5, 0, 1, 2});
		mp3.solution(new int[]{-100, 1, 2, 3});
		mp3.solution(new int[]{-3, 1, 2, -2, 5, 6});
	}
}

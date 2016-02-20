package codility.lesson3;

import java.util.Arrays;

public class TapeEquilibrium {
	public int solution(int[] A) {

		int[] leftSums = new int[A.length];
		int[] rightSums = new int[A.length];

		leftSums[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			leftSums[i] = leftSums[i - 1] + A[i];
		}

		// System.out.println("Left sums: " + Arrays.toString(leftSums));

		rightSums[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			rightSums[i] = rightSums[i + 1] + A[i];
		}

		// System.out.println("Right sums: " + Arrays.toString(rightSums));

		int minDiff = Integer.MAX_VALUE;
		int currDiff;
		for (int i = 0; i < A.length - 1; i++) {
			currDiff = Math.abs(leftSums[i] - rightSums[i + 1]);
			if (currDiff < minDiff) {
				minDiff = currDiff;
			}
		}

		System.out.println(Arrays.toString(A) + " => " + minDiff);

		return minDiff;
	}

	public static void main(String[] args) {
		TapeEquilibrium te = new TapeEquilibrium();
		te.solution(new int[]{1,2,1});    
		te.solution(new int[]{3,1,2,4,3});
	}

	
}
package codility.lesson6;

import java.util.*;

public class Triangle {

	public int solution(int[] A) {
		int result = 0;

		if (A.length > 2) {
			Arrays.sort(A);

			for (int p = 0; p < A.length - 2; p++) {
				if ((long)A[p] + (long)A[p+1] > A[p+2]) {
					result = 1;
					break;
				}
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		Triangle triangle = new Triangle();
		System.out.println(triangle.solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
		System.out.println(triangle.solution(new int[]{1,1,1}));
	}
	 
}

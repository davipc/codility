package codility.lesson2;

import java.util.Arrays;

public class CyclicRotation {

	public int[] solution(int[] A, int K) {
		int[] result = null;

		String arrStr =  Arrays.toString(A);
		
		if (A != null) {
			result = new int[A.length];
		}

		for (int i = 0; i < A.length; i++) {
			result[(i + K) % A.length] = A[i];
		}

		System.out.println(arrStr + " " + K + "=> " + Arrays.toString(result));

		return result;
	}

	public static void main(String[] args) {
		CyclicRotation cr = new CyclicRotation();
		cr.solution(new int[]{}, 0);
		cr.solution(new int[]{}, 1);
		cr.solution(new int[]{1}, 0);
		cr.solution(new int[]{1}, 1);
		cr.solution(new int[]{1,2}, 0);
		cr.solution(new int[]{1,2}, 1);
		cr.solution(new int[]{1,2}, 2);
		cr.solution(new int[]{1,2}, 3);
		cr.solution(new int[]{1,2}, 4);
	}
	
	
}

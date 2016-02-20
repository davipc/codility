package codility.lesson4;

import java.util.Arrays;

public class PermCheck {
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
		PermCheck pc = new PermCheck();
		
		pc.solution(new int[]{});
		pc.solution(new int[]{2});
		pc.solution(new int[]{2,1});
		pc.solution(new int[]{4,3,2});
		pc.solution(new int[]{2,3,4,5,1});
		pc.solution(new int[]{2,3,4,6,1});
	}

}

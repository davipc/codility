package codility.lesson13;

import java.util.Arrays;

public class Ladder {
	public int[] solution(int[] A, int[] B) {
		int L = A.length;
		
		int[] result = new int[L];
		
		// we can make all fib numbers lower than the max modulo, since each modulo value will always be a another power of 2 (crazy) 
		int maxModulo = (int)Math.pow(2, 30);

		int[] fibRestricted = new int[L+2];
		fibRestricted[1] = 1;
		for (int i = 2; i < L+2; i++) {
			fibRestricted[i] = (fibRestricted[i-1] + fibRestricted[i-2]) % maxModulo;
		}

		System.out.println("Fib: " + Arrays.toString(fibRestricted) );
		
		for (int i = 0; i < L; i++) {
			result[i] = fibRestricted[A[i]+1] % (int)Math.pow(2, B[i]);  
		}

		//System.out.println("(" + Arrays.toString(A) + "," + Arrays.toString(B) + ") => " + Arrays.toString(result));
		
		return result;
	}

	public static void main(String[] args) {
		Ladder ladder = new Ladder();
		
		//ladder.solution(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1});
		
		// sending big array for testing
		int[] A = new int[30000];
		int[] B = new int[30000];
		for (int i = 1; i <= 30000; i++) {
			A[i-1] = i;
			B[i-1] = i%31;
		}
		ladder.solution(A, B);
		
	}
	
}

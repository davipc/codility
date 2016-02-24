package codility.lesson11;

import java.util.Arrays;

public class CountNonDivisible {
	
	public int[] solution(int[] A) {
		int N = A.length;
		int[] result = new int[N];
		
		// count the number of entries per number
		int[] numberCounts = new int[N*2+1];
		for (int i: A) {
			numberCounts[i]++;
		}
		
		int divisors;
		// now count number of divisors for each element in the array (could be improved by only counting once per number)
		for (int i = 0; i < N; i++) {
			divisors = 0;
			// just need to check up to sqrt(i), as 
			//For each divisor found there is also a symmetric divisor (for instance, N=6, divisor 2 has symmetric 3)
			// So, every time we find a divisor below sqrt(N), we also count the symmetric one. If symmetric is the same as 
			// the divisor itself, count only once (when the divisor is the same as sqrt(N))			
			int j = 1;
			for (; j * j < A[i]; j++) {
				if (A[i] % j == 0)
					divisors += numberCounts[j] + numberCounts[A[i]/j];
			}
			if (j * j == A[i]) {
				divisors += numberCounts[j];
			}
			
			result[i] = N - divisors;
		}

		System.out.println(Arrays.toString(A) + " => " + Arrays.toString(result));
		
		return result;
	}

	public static void main(String[] args) {
		CountNonDivisible cnd = new CountNonDivisible();
		cnd.solution(new int[]{2,1,3});
		cnd.solution(new int[]{3,1,2,3,6});
		cnd.solution(new int[]{1,2,3,5,7,11,13});
		cnd.solution(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
	}
}

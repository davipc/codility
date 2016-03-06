package codility.lesson11;

import java.util.Arrays;

/**
 * 
You are given a non-empty zero-indexed array A consisting of N integers.

For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. 
We say that these elements are non-divisors.

For example, consider integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
For the following elements:

A[0] = 3, the non-divisors are: 2, 6,
A[1] = 1, the non-divisors are: 3, 2, 3, 6,
A[2] = 2, the non-divisors are: 3, 3, 6,
A[3] = 3, the non-divisors are: 2, 6,
A[6] = 6, there aren't any non-divisors.
Write a function:

class Solution { public int[] solution(int[] A); }

that, given a non-empty zero-indexed array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

The sequence should be returned as:

a structure Results (in C), or
a vector of integers (in C++), or
a record Results (in Pascal), or
an array of integers (in any other programming language).
For example, given:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
the function should return [2, 4, 3, 2, 0], as explained above.

Assume that:

N is an integer within the range [1..50,000];
each element of array A is an integer within the range [1..2 * N].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
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

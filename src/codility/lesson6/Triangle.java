package codility.lesson6;

import java.util.*;

/**
 * 
A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

class Solution { public int solution(int[] A); }

that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 * 
 * @author Davi
 *
 */
public class Triangle {

	public int solution(int[] A) {
		int result = 0;

		if (A.length > 2) {
			Arrays.sort(A);

			// for every ordered triple (P,Q,R), we already know that R + any of the other 2 will be higher than the remaining one.
			// so we only need to check if A[P] + A[Q] > A[R]
			// also, if a smaller P and Q is enough to satisfy the condition (R fixed), higher ones will also satisfy it. Also, a lower R would also be a triangle.  
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

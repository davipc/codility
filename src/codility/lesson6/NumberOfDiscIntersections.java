package codility.lesson6;

import java.util.*;

/**
 * 
We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, 
is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point 
(assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0


There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. 
The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * 
 * @author Davi
 *
 */
public class NumberOfDiscIntersections {

	public int solution(int[] A) {
		int result = 0;

		String arrayStr = Arrays.toString(A);
		
		int N = A.length;

		long[] Ds = new long[N];
		long[] De = new long[N];

		// first create arrays with starts and ends of each disc
		// need to cast ints to longs so adding/subtracting doesn't return
		// overflowed value
		for (int i = 0; i < N; i++) {
			Ds[i] = (long) i - (long) A[i];
			De[i] = (long) i + (long) A[i];
		}

		// System.out.println("Borders: " + Arrays.toString(Ds) + " " +
		// Arrays.toString(De));

		// order both arrays
		Arrays.sort(Ds);
		Arrays.sort(De);

		// System.out.println("Ordered borders: " + Arrays.toString(Ds) + " " +
		// Arrays.toString(De));

		// now scan both arrys at the same time
		// every time a new disc starts, add the number of current discs -1 to
		// the total count
		// every time a disc ends, decrease the number of overlapping discs
		int currDiscCount = 0;
		int iDs = 0;
		int iDe = 0;

		while (iDs < N && iDe < N) {
			while (iDs < N && iDe < N && Ds[iDs] <= De[iDe]) {
				currDiscCount++;
				result += currDiscCount - 1;
				iDs++;

				// interrupt, too many intersections found
				if (result > 10000000) {
					return -1;
				}
			}

			while (iDs < N && iDe < N && Ds[iDs] > De[iDe]) {
				currDiscCount--;
				iDe++;
			}
		}

		System.out.println(arrayStr + " => " + result);
		
		return result;
	}

	
	public static void main(String[] args) {
		NumberOfDiscIntersections nodi = new NumberOfDiscIntersections();
		
		nodi.solution(new int[]{});
		nodi.solution(new int[]{0});
		nodi.solution(new int[]{1});
		nodi.solution(new int[]{0, 0, 0});
		nodi.solution(new int[]{1,2,3,4,5});
		nodi.solution(new int[]{5,4,3,2,1});
		nodi.solution(new int[]{0, 2147483647, 1});
		nodi.solution(new int[]{1,5,2,1,4,0});
	}
}

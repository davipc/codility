package codility.lesson6;

import java.util.*;

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

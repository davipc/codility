package codility.lesson5;

import java.util.Arrays;


/**
 * 
A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A 
(notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length 
of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice with the minimal average. 
If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 * 
 * 
 * @author Davi
 *
 */
public class MinAvgTwoSlice {
	 public int solution(int[] A) {
		 int result = -1;

		 int N = A.length;
		 
		 // The big catch is to realize that the minimal avg slice will be of sizes 2 or 3. 
		 // If there is an avg of 4 elements that makes it even smaller than the previous average of 3 (which was minimal), then the avg of this element with the previous one would be even smaller.   
		 // So we just need to check avgs with 2 or 3 elements, and store the startingIdx when avg is minimal 
		 // example: 1000, 0, -1, 10, -100, -1, 1000 => [-1, 10, -100] is minimal, [-1, 10, -100, -1] is smaller, but then [-100, -1] is even smaller
		 // 
		 // Think of the case in which there are the slice made of four slots. Let's assume these four slots can produce the minimum average. 
		 // The slice can be decomposed into two pairs, each of which consists two slots. If any of these pairs can produce a smaller average than the original four slots, then it contradicts the 
		 // first assumption. If they produce a bigger average, then the other pair must be smaller than the average of the original four slots. So will be the same value. 
		 // The same can be said to 5 slots (2+3), etc.
		 
		 double minAvg = Double.MAX_VALUE;
		 int minAvgIdx = -1;
		 double avg2;
		 double avg3;
		 for (int i = 0; i < N-2; i++) {
			 avg2 = ((double)(A[i] + A[i+1])) / 2;
			 avg3 = ((double)(A[i] + A[i+1] + A[i+2])) / 3;
			 if (avg2 < minAvg) {
				 minAvg = avg2;
				 minAvgIdx = i;
			 }
			 // even if avg2 was lower, avg3 could have an even lower avg - need to store it as min for later checks
			 if (avg3 < minAvg) {
				 minAvg = avg3;
				 minAvgIdx = i;
			 }
		 }
		 // check avg of last 2 elements
		 avg2 = ((double)(A[N-2] + A[N-1]))/2;
		 if (avg2 < minAvg) {
			 minAvg = avg2;
			 minAvgIdx = N-2;
		 }
		 
		 result = minAvgIdx;
		 
		 System.out.println(Arrays.toString(A) + " => " + result + " (" + minAvg + ")");
		 
		 return result;
	 }
	 
	 
	 public static void main(String[] args) {
		MinAvgTwoSlice min = new MinAvgTwoSlice();
		
		min.solution(new int[]{1,2});
		min.solution(new int[]{1,2,1,1});
		min.solution(new int[]{4,2,2,5,1,5,8});
	}
}

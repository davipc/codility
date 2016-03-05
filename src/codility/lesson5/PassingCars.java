package codility.lesson5;

import java.util.Arrays;

/**
 * 
A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is 
traveling to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */

public class PassingCars {

	public int solution(int[] A) {
        int total = 0;
        int count = 0;

        String arrayStr = Arrays.toString(A);
        
        // start counting from the right, as '1's to the right of '0's will be considered for every such '0's
        for (int i = A.length-1; i >= 0; i--) {
            // if '1', increase the count
            if (A[i] == 1) count++;
            
            // if '0', add current count to total
            if (A[i] == 0) total += count;
            
            if (total > 1000000000) {
                total = -1;
                break;
            }
        }
        
        System.out.println(arrayStr + " => " + total);
        
        return total;
    }

	public int solution2(int[] A) {
        int total = 0;
        int countE = 0;

        String arrayStr = Arrays.toString(A);
        
        // this also works - count cars going east, every time a car going W passes, add the count to total 
        for (int i = 0; i < A.length; i++) {
            // if '0' (E), increase the count
            if (A[i] == 0) countE++;
            // if '1' (W), add current count to total
            else total += countE; 
            
            if (total > 1000000000) {
                total = -1;
                break;
            }
        }
        
        System.out.println(arrayStr + " => " + total);
        
        return total;
    }
	
	private static String checkEqual(int i1, int i2) {
		return i1 == i2 ? "equal" : "not equal"; 
	}
	
	
	public static void main(String[] args) {
		PassingCars pc = new PassingCars();

		System.out.println(checkEqual(pc.solution(new int[]{0}), pc.solution2(new int[]{0})));
		System.out.println(checkEqual(pc.solution(new int[]{1}), pc.solution2(new int[]{1})));
		System.out.println(checkEqual(pc.solution(new int[]{0,0}), pc.solution2(new int[]{0,0})));
		System.out.println(checkEqual(pc.solution(new int[]{1,1}), pc.solution2(new int[]{1,1})));
		System.out.println(checkEqual(pc.solution(new int[]{1,0}), pc.solution2(new int[]{1,0})));
		System.out.println(checkEqual(pc.solution(new int[]{0,1}), pc.solution2(new int[]{0,1})));
		System.out.println(checkEqual(pc.solution(new int[]{1,1,1,1,0}), pc.solution2(new int[]{1,1,1,1,0})));
		System.out.println(checkEqual(pc.solution(new int[]{0,1,0,1,1}), pc.solution2(new int[]{0,1,0,1,1})));
		System.out.println(checkEqual(pc.solution(new int[]{0,0,0,0,0,0,1,1}), pc.solution2(new int[]{0,0,0,0,0,0,1,1})));
	}	
	
}

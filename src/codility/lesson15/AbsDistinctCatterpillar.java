package codility.lesson15;

import java.util.Arrays;

/**
 *  
A non-empty zero-indexed array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

For example, consider array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A consisting of N numbers, returns absolute distinct count of array A.

For example, given array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
the function should return 5, as explained above.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
array A is sorted in non-decreasing order.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 *  
 * @author Davi
 *
 */
public class AbsDistinctCatterpillar {
    public int solution(int[] A) {
        int result = 0;
        
        int N = A.length;

        if (N == 1)
            result = 1;
        else {
            // CANNOT turn all elements into abs value, as abs(Integer.MIN_VALUE) is the same negative value) 
            
            int s = 0;
            int e = N-1;
            
            result = 1;
            
            while (s < e) {
                while (s < e && Math.abs((long)A[e]) >= Math.abs((long)A[s])) {
                    if (Math.abs((long)A[e]) > Math.abs((long)A[s]))
                        result++;
                    e--;
                    // if we are now in the middle of a sequence of numbers with same value, 
                    // we need to get out of the sequence (value has already been counted)
                    while (s < e && A[e] == A[e+1])
                    	e--;
                }
                while (s < e && Math.abs((long)A[s]) >= Math.abs((long)A[e])) {
                    if (Math.abs((long)A[s]) > Math.abs((long)A[e]))
                        result++;
                    s++;
                    // if we are now in the middle of a sequence of numbers with same value, 
                    // we need to get out of the sequence (value has already been counted)
                    while (s < e && A[s] == A[s-1])
                    	s++;
                }
            }
        }
        
        System.out.println(Arrays.toString(A) + " => " + result);
        
        return result;
    }
    
    public static void main(String[] args) {
		AbsDistinctCatterpillar abs = new AbsDistinctCatterpillar();
		
		abs.solution(new int[]{1});
		
		abs.solution(new int[]{-5, -3, -1, 0, 3, 6});
		
		abs.solution(new int[]{1,2,3,4,5,6});
		
		abs.solution(new int[]{-1,-1});
		
		abs.solution(new int[]{-2147483648, -1, 0, 1});
		
		abs.solution(new int[]{-5,-4,-4,-4,-4,-3,-2,-1, -1, 0, 1,2,2,2,2,3,4,4,4,4,4,4,4,5});
		
	}
}
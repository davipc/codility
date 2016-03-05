package codility.lesson3;

/**
 * 
A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], 
which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given a zero-indexed array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 * @author Davi
 *
 */
public class PermMissingElement {
    public int solution(int[] A) {
        int result;
        
        //String arrayStr = Arrays.toString(A);
        
        long N = A.length;

        // if all elements from 1 to N are there, sum will be the one defined in the formula
        // if some number is missing, all numbers starting at it were added 1 
        long diff = N*(N+1)/2;
        for (int i = 0; i < A.length; i++) {
        	diff -= A[i];
        }
        
        // result will be N+1 sub that difference 
        // i.e.: 123, diff is 0 => 4 is missing (N+1 - 0)
        // 124, diff is -1 => 3 is missing (N+1 - 1)
        // ...
        
        result = (int)N + 1 + (int)diff;
        
        //System.out.println(arrayStr + " => " + result);
        //System.out.println(" => " + result);
        
        return result;
    }
	    
    public static void main(String[] args) {
		PermMissingElement pme = new PermMissingElement();
		
		pme.solution(new int[]{});
		pme.solution(new int[]{1});
		pme.solution(new int[]{2});
		pme.solution(new int[]{3,1});
		pme.solution(new int[]{4,3,2});
		pme.solution(new int[]{6,3,4,5,1});
		pme.solution(new int[]{2,3,4,6,1});
	
		// 100000 missing
		int[] bigRange = new int[100000];
		int N = bigRange.length;
		for (int i = 0; i < N-1; i++)
			bigRange[i] = i+1;
		bigRange[N-1] = 100000 + 1;
		pme.solution(bigRange);

		// 1 missing
		for (int i = 0; i < N; i++)
			bigRange[i] = i+2;
		pme.solution(bigRange);

    }
}

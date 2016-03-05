package codility.lesson99;

/**
 * 

A zero-indexed array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].

Write a function:

class Solution { public int solution(int[] A); }

that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
For example, in the following array:

A[0] = -1 A[1] = 6 A[2] = 3
A[3] =  4 A[4] = 7 A[5] = 4
there are four inversions:

  (1,2)  (1,3)  (1,5)  (4,5)
so the function should return 4.

Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * The N*log(N) solution to this problem is to count how many element swap operations are needed during a merge (or heap) sort execution on the input array.
 * For that, we would need to implement a modified version of the algorithm, keeping track of swap operation count 
 * 
 * @author Davi
 *
 */
public class ArrayInversionCount {
    public int solution(int[] A) {
        int result = 0;

        int N = A.length;
        
        for (int i = 1; i < N; i++) {
        	for (int j = 0; j < i; j++) {
        		if (A[i] > A[j])
        			result++;
        	}
            
        }
        
        return result;
    }
    
    
}

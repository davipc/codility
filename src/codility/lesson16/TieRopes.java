package codility.lesson16;

import java.util.Arrays;

/**
 * 
There are N ropes numbered from 0 to N − 1, whose lengths are given in a zero-indexed array A, lying on the floor in a line. For each I (0 ≤ I < N), 
the length of rope I on the line is A[I].

We say that two ropes I and I + 1 are adjacent. Two adjacent ropes can be tied together with a knot, and the length of the tied rope is the 
sum of lengths of both ropes. The resulting new rope can then be tied again.

For a given integer K, the goal is to tie the ropes in such a way that the number of ropes whose length is greater than or equal to K is maximal.

For example, consider K = 4 and array A such that:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 1
    A[5] = 1
    A[6] = 3
The ropes are shown in the figure below.



We can tie:

rope 1 with rope 2 to produce a rope of length A[1] + A[2] = 5;
rope 4 with rope 5 with rope 6 to produce a rope of length A[4] + A[5] + A[6] = 5.
After that, there will be three ropes whose lengths are greater than or equal to K = 4. It is not possible to produce four such ropes.

Write a function:

class Solution { public int solution(int K, int[] A); }

that, given an integer K and a non-empty zero-indexed array A of N integers, returns the maximum number of ropes of length greater than or equal to K 
that can be created.

For example, given K = 4 and array A such that:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 1
    A[5] = 1
    A[6] = 3
the function should return 3, as explained above.

Assume that:

N is an integer within the range [1..100,000];
K is an integer within the range [1..1,000,000,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
public class TieRopes {

	public int solution(int K, int[] A) {
        int result = 0;
        
        int N = A.length;
        
        // just for printing at the end
        String arrStr = Arrays.toString(A);
        
        // if only one knot, return 1 if size >= k, 0 otherwise
        if (N == 1)
            result = A[0] >= K ? 1 : 0;
        else {
            // we always tie knots until size >= K.
        	// the logic is: if we avoid creating a knot >= K to spare a following knot, 
        	// it will be used to create exactly one knot - that is, there is no gain in saving it for later
        	// moreover, it might end up not even being needed, so it's always best to use a knot to create a knot >= K as soon as it's useful
        	// so, just always use it now
        	for (int i = 0; i < N-1; i++) {
                if (A[i] < K) {
                    A[i+1] += A[i];
                    A[i] = 0;
                }
            }
            
            // all tying is done. Now count knots for which size > K
            for (int i = 0; i < N; i++) {
                if (A[i] >= K)
                    result++;
            }
        }        
        
        System.out.println("(" + K + ", " + arrStr + ") => " + result + " ; " + Arrays.toString(A));
        return result;
    }
	
	public static void main(String[] args) {
		TieRopes tie = new TieRopes();
		
		tie.solution(4, new int[]{3});
		tie.solution(1000000000, new int[]{1000000000});
		tie.solution(1000000000, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 23, 1, 1, 1});
		tie.solution(1, new int[]{4, 1, 2, 5, 2, 1000000000, 6, 7, 2, 4, 3});
		tie.solution(10, new int[]{1, 5, 4, 2, 4, 10});
		tie.solution(10, new int[]{1, 10, 9, 2, 8});
		tie.solution(10, new int[]{10, 1, 10, 1, 2, 3, 4});
		tie.solution(4, new int[]{1, 2, 3, 4, 1, 1, 3});
	}
}

package codility.lesson15;

import java.util.Arrays;

/**
 * 
A zero-indexed array A consisting of N integers is given. 
A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R]. 
In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 12
There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).

Write a function:

int solution(int A[], int N);

that, given a zero-indexed array A consisting of N integers, returns the number of triangular triplets in this array.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 12
the function should return 4, as explained above.

Assume that:

N is an integer within the range [0..1,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N2);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
public class CountTriangles {
    public int solution(int[] A) {
        int result = 0;
        
        // sort the elements so we know when to stop trying to move the caterpillar head ahead
        Arrays.sort(A);
        
        int N = A.length;
        
        int tail;
        int head;
        boolean b;
        
        for (int i = 0; i <= N-3; i++) {
            tail = i+1;
            head = i+2;
            
            // we know that every position between tail and head will be bigger than tail, so we can just keep pushing head and 
            // adding tail-head each time it is still a triangle (as every triple starting at i and ending at head will form a triangle) 
            while (head <= N-1) {
                b = checkTriangle(A[i], A[tail], A[head]);
                
                if (b) {
                    result += head - tail;
                    head++;
                } else if (tail + 1 < head) {
                    tail++;
                } else {
                	tail++;
                	head++;
                }
            }
        }
        
        System.out.println(Arrays.toString(A) + " => " + result);
        
        return result;
    }
    
    /**
     * Considering e1 <= e2 <= e3, checks if the 3 numbers form a triangle
     * (only first check is enough if numbers are ordered like that)
     * @param e1
     * @param e2
     * @param e3
     * @return
     */
    private boolean checkTriangle(int e1, int e2, int e3) {
    	return 
            e1 + e2 > e3;
//            && 
//            e2 + e3 > e1 &&
//            e3 + e1 > e2;
    }

    
    public static void main(String[] args) {
		CountTriangles count = new CountTriangles();
		
		count.solution(new int[]{10,2,5,1,8,12});
		count.solution(new int[]{1,2,2,2,3,4,4});
		count.solution(new int[]{2,2,2,2,2,2,2,2});
		
		count.solution(new int[]{2,2,2,2});
		count.solution(new int[]{2,2,2,2,2});
		count.solution(new int[]{1,2,3,4,5});
	}
}

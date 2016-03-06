package codility.lesson10;

import java.util.*;

/**
 * 
A non-empty zero-indexed array A consisting of N integers is given.

A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
has exactly three peaks: 3, 5, 10.

We want to divide this array into blocks containing the same number of elements. 
More precisely, we want to choose a number K that will yield the following blocks:

A[0], A[1], ..., A[K − 1],
A[K], A[K + 1], ..., A[2K − 1],
...
A[N − K], A[N − K + 1], ..., A[N − 1].
What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, 
but only if they have both neighbors (including one in an adjacent blocks).

The goal is to find the maximum number of blocks into which the array A can be divided.

Array A can be divided into blocks as follows:

one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. 
Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), 
because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].

The maximum number of blocks that array A can be divided into is three.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A consisting of N integers, returns the maximum number of blocks into which A can be divided.

If A cannot be divided into some number of blocks, the function should return 0.

For example, given:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
the function should return 3, as explained above.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [0..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N*log(log(N)));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
public class Peaks {

	public int solution(int[] A) {
        int result = 0;
    
        int N = A.length;

        System.out.println("In" + Arrays.toString(A) + "; N = " +N);
        
        // mark accumulated peaks
        int[] peaks = new int[N];
        int count = 0;
        for (int i = 1; i < N -1; i++) {
            if (A[i-1] < A[i] && A[i+1] < A[i])
                count++;    
            peaks[i] = count;
        }
        // set peaks count on last elem as it will be needed during div checks
        peaks[N-1] = count;
        
        System.out.println("Peaks: " + Arrays.toString(peaks));
        
        // check count
        if (count > 0) {
            // if only one peak, will need the whole array
            if (count == 1)
                result = 1;
            else {

            	// at this point (peaks > 1) we know at least the single group will satisfy the criteria
            	// so set result to 1, then check for bigger numbers of groups
            	result = 1;
            	
            	// for each divisor of N, check if that number of groups work
                Integer[] divisors = getDivisors(N);
                
                // result will be at least 1 at this point
                boolean candidate;
                int divisor, startIdx, endIdx;
                // check from top value to bottom - stop when one is found
                // for div 1 we know num groups is 1, and we already know that is the minimum. No need to check.
                // for div = N we know it's impossible, as all elements would have to be peaks (impossible by definition)
                for (int i = divisors.length-2; i > 0; i--) {
                    candidate = true;
                    divisor = divisors[i];
                    
                    System.out.println("Checking div = " + divisor);
                    
                    for (int j = 0; j < N; j+= N/divisor) {
                        startIdx = (j == 0 ? j : j-1);
                        endIdx = j + N/divisor-1;
                        
                        if (peaks[startIdx] == peaks[endIdx]) {
                            candidate = false;
                            break;
                        }
                    }
                    
                    // if all groups had at least 1 peak, this is the result!
                    if (candidate) {
                        result = divisor;
                        break;
                    }
                }
                
            }
        }
                      
        System.out.println("Result -> " + result);
        System.out.println();
        
        return result;
    }
    
    private Integer[] getDivisors(int N) {
        Set<Integer> set = new TreeSet<Integer>();
        
        double sqrt = Math.sqrt(N);
        int i = 1;
        for (; i < sqrt; i++) {
            if (N % i == 0) {
                set.add(i); 
                set.add(N/i);
            }
        }
        if (i * i == N)
            set.add(i);
            
        return set.toArray(new Integer[]{});
    }
    
    
    public static void main(String[] args) {
		Peaks p = new Peaks();
		p.solution(new int[]{1});
		p.solution(new int[]{1,2,1});
		p.solution(new int[]{1,2,1,1,1});
		p.solution(new int[]{1,2,3,4,5,6,5});
		p.solution(new int[]{1,2,3,4,5,6,5,4,3,2,1});
		p.solution(new int[]{1,4,3,4,5,5,5,4,3,2,1,2,3});
		p.solution(new int[]{1,4,3,4,5,5,5,4,3,2,1,2,3,4,5,6,7});
		p.solution(new int[]{1,4,3,4,5,5,5,4,3,2,1,2,3,4,5,6,7,8,9});
		p.solution(new int[]{1,2,3,4,5,5,5,4,3,2,1,2,3,4,5,6,7,9,8,10,9});
	}
}

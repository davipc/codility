package codility.lesson8;

import java.util.Arrays;

/**
 * 
A non-empty zero-indexed array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders 
of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 * 
 * @author Davi
 *
 */
public class EquiLeader {
	 public int solution(int[] A) {
        int result = 0;
                
        // first find the leader
        int leader = findLeader(A);
        
        // now start counting equi-leaders
        // we know equi-leader sets will always be led by the same leader of the entire set (in order for leaders to be the same on each side) 
    
        if (leader > Integer.MIN_VALUE) {
            // create 2 arrays, one indicating if leader is leader for each sub-set left->right and another indicating if leader for each sub-set right->left
            // both are initialized with 0s
            int[] leaderLeft = new int[A.length];
            int[] leaderRight = new int[A.length];
            
            int count = 0;
            // use this counter for clarity - to avoid index counting when iterating backwards (right to left)
            int subSetSize = 0;
            for (int i = 0; i < A.length; i++) {
                subSetSize++;
                if (A[i] == leader)
                    count++;
                if (count > subSetSize/2)
                    leaderLeft[i] = 1;
            }
            
            count = 0;
            subSetSize = 0;
            for (int i = A.length-1; i >= 0; i--) {
                subSetSize++;
                if (A[i] == leader)
                    count++;
                if (count > subSetSize/2)
                    leaderRight[i] = 1;
            }
            
            //now run through both arrays, checking if they are both leaders on the complementing sets
            for (int i = 0; i < leaderLeft.length-1; i++) {
                if (leaderLeft[i] == 1 && leaderRight[i+1] == 1)
                    result++;
            }
        }        
        
        System.out.println(Arrays.toString(A) + " => " + result);
        
        return result;
	 }
	    
    private int findLeader(int[] A) {
        int leader = Integer.MIN_VALUE;
    
        int candidateCount = 1;
        int candidate = A[0];
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] == candidate) {
                candidateCount++;   
            } else {
                candidateCount--;
                if (candidateCount == 0) {
                    candidate = A[i];
                    candidateCount = 1;
                }
            }
        }

        // if there were any candidates left at the end, check if it's the leader
        int finalCount = 0;
        if (candidateCount > 0) {
            for (int i = 0; i < A.length; i++) {
                finalCount++;
            }
        }
        
        if (finalCount > A.length / 2)
            leader = candidate;
        
        return leader;       
    }
	    
    public static void main(String[] args) {
		EquiLeader el = new EquiLeader();
		el.solution(new int[]{1});
		el.solution(new int[]{1,1});
		el.solution(new int[]{1,2,1});
		el.solution(new int[]{1,2,3,1,1});
		el.solution(new int[]{2,3,1,1,4,1,5,6});
		el.solution(new int[]{4,3,4,4,4,2});
		el.solution(new int[]{4,3,4,4,4,2,3,4});
		
		
	}
}

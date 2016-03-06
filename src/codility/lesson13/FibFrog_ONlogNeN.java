package codility.lesson13;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
The Fibonacci sequence is defined using the following recursive formula:

    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2
A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in a zero-indexed array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

0 represents a position without a leaf;
1 represents a position containing a leaf.
The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:

class Solution { public int solution(int[] A); }

that, given a zero-indexed array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. 
If the frog cannot reach the other side of the river, the function should return −1.

For example, given:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
the function should return 3, as explained above.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
public class FibFrog_ONlogNeN {
	public int solution(int []A) {
		int result = -1;
		
		int N = A.length;
		
		int[] fibArr = getFibArray(N+1);
		
		int leavesNum = 0;
		for (int leaf: A) {
			if (leaf == 1)
				leavesNum++;
		}
		
		int[] distances = new int[leavesNum + 1];
		int idxDist = 0;
		for (int i = 0; i < N; i++)
			if (A[i] == 1)
				distances[idxDist++] = i+1;
		distances[leavesNum] = N+1;

		// first find the first possible leave to jump to (must be a fibonacci number)
		int firstDistIdx;
		for (firstDistIdx = 0; firstDistIdx < distances.length; firstDistIdx++) {
			if (fibArr[distances[firstDistIdx]] == 1) {
				break;
			}
		}

		Stack[] hops = new Stack[distances.length];
		Stack lastDistHops;
		// if a first possible leaf was found, start from it
		if (firstDistIdx < distances.length) {
			for (int distIdx = firstDistIdx; distIdx < distances.length; distIdx++) {
				hops[distIdx] = new Stack();
				// either this distance is reachable directly
				if (fibArr[distances[distIdx]] == 1) {
					hops[distIdx].push(distances[distIdx]);
				} 
				// or it needs to be reachable from one of the past reachable distances - we need to try to find the one with fewer hops
				else {
					int nextNeededHop = 0;
					int distancesBehind = 1;
					int minPrevious = -1;
					int minPreviousHops = Integer.MAX_VALUE;
					while (minPreviousHops > 1 && distIdx - distancesBehind >= firstDistIdx) {
						nextNeededHop = distances[distIdx] - distances[distIdx-distancesBehind];
						if (fibArr[nextNeededHop] == 1 && !hops[distIdx-distancesBehind].empty() && 
							hops[distIdx-distancesBehind].size() < minPreviousHops) {

							minPrevious = distIdx-distancesBehind;
							minPreviousHops = hops[minPrevious].size();
						}

						distancesBehind++;
					} 
					
					if (minPrevious >= 0) {
						lastDistHops = hops[minPrevious];
						nextNeededHop = distances[distIdx] - distances[minPrevious];
						 
						int lastDistLastHop = (int) lastDistHops.get(lastDistHops.size() -1); 
						// if last distance was covered by a single hop, just add the new needed hop there
						if (lastDistHops.size() == 1) {
							hops[distIdx].push(lastDistLastHop);
							hops[distIdx].push(nextNeededHop);
						} 
						// otherwise, 
						else {
							// current distance will be covered by last distance + next needed hop
							hops[distIdx].addAll(lastDistHops);
							
							// check if the last hop and this one can be replaced with a single hop (F(last) + F(needed) = F(curr))
							// then check again (until no more reductions possible)
							int hopAdding = nextNeededHop;
							int lastHop;
							boolean reduced = true;
							do {
								lastHop = (int)hops[distIdx].peek();
								if (fibArr[lastHop + hopAdding] == 1) {
									hops[distIdx].pop();
									hopAdding = lastHop + hopAdding;
								} else {
									reduced = false;
								}
							} while (reduced && !hops[distIdx].isEmpty());
							
							hops[distIdx].push(hopAdding);

						}
					}
				}
			}
		}
		
		String hopsStr = "[]";
		if (hops[distances.length-1] != null && !hops[distances.length-1].empty()) {
			hopsStr = Arrays.toString(hops[distances.length-1].toArray(new Integer[hops[distances.length-1].size()])); 
			result = hops[distances.length-1].size();
		}
		
		System.out.println("(" + A.length + ") " + Arrays.toString(A) + " => " + result + " => "  + hopsStr);
		
		return result;
	}

	private int[] getFibArray(int N) {
		int[] fibArr = new int[N+1];
		
		int prev1 = 1;
		int prev2 = 0;

		fibArr[0] = 1;
		fibArr[1] = 1;
		
		int curr;
		do {
			curr = prev1 + prev2;
			fibArr[curr] = 1;
			
			prev2 = prev1;
			prev1 = curr;
		} while (prev1 + prev2 <= N);

		//System.out.println("FibArray: " + Arrays.toString(fibArr));
		
		return fibArr;
	}
	
	public static void main(String[] args) {
		FibFrog_ONlogNeN ff = new FibFrog_ONlogNeN();
		
		ff.solution(new int[]{0,0,0,1,1,0,1,0,0,0,0});
		ff.solution(new int[]{0,0,0,1,1,0,1,0,0});
		ff.solution(new int[]{0,0,0,1,1,0,1,0,0,0});
		ff.solution(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
		ff.solution(new int[]{});
		ff.solution(new int[]{1});
		ff.solution(new int[]{1, 1, 0, 0, 0});		
		ff.solution(new int[]{0, 0, 1, 0, 0, 0, 1, 1, 1, 1});
		
		// can't cross
		ff.solution(new int[]{0,0,0});
		
	}
}

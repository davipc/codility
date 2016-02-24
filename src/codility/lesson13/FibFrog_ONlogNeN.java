package codility.lesson13;

import java.util.Arrays;
import java.util.Stack;

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

package codility.lesson4;

import java.util.*;

public class MaxCounters {
	public int[] solution(int N, int[] A) {
        int[] positions = new int[N];
        
        String arrayStr = Arrays.toString(A);
        
        Arrays.fill(positions, 0);
        
        int maxValue = 0;
        // have to use the lowBar (instead of updating array elements) in order to achieve O(N+M)
        int lowBar = 0;
        int value;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                lowBar = maxValue;
            } else {
            	// first check if this counter's value is below the low bar
                value = positions[A[i]-1];
                if (value < lowBar)
                	value = lowBar+1;
                else 
                	value++;
                
                positions[A[i]-1] = value;
                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }
        
        // finally set the low bar to the counters with value still below it
        for (int i = 0; i < positions.length; i++) {
        	if (positions[i] < lowBar) {
        		positions[i] = lowBar;
        	}
        }
        
        System.out.println("(" + N + ", " + arrayStr + ") => " + Arrays.toString(positions));
        
        return positions;
    }    
    
	public static void main(String[] args) {
    	MaxCounters mc = new MaxCounters();
    	
    	mc.solution(1, new int[]{2});
    	mc.solution(1, new int[]{1});
    	mc.solution(1, new int[]{2,1});
    	mc.solution(1, new int[]{1,2});
    	mc.solution(1, new int[]{2,2,2});
    	mc.solution(1, new int[]{1,1,1});
    	mc.solution(1, new int[]{1,2,1});
    	mc.solution(2, new int[]{3});
    	mc.solution(2, new int[]{2});
    	mc.solution(2, new int[]{1});
    	mc.solution(2, new int[]{1,3,1});
    	mc.solution(3, new int[]{1,2,1,1,1,1,1,4,3});
    	mc.solution(3, new int[]{2,3,4});
	}
}

package codility.lesson16;

import java.util.Arrays;

public class MaxNonoverlappingSegments {
	public int solution(int[] A, int[] B) {
        int result = 0;
        
        int N = A.length;
        
        if (N <= 1) {
            result = N;
        } else {
            int prevChosen;
            result++;
            
            prevChosen = 0;
            
            for (int i = 1; i <= N-1; i++) {
                // if it doesn't overlap, that the next optimal choice (smaller A[i], and we know smaller B[i] as well since B is ordered)
                if (A[i] > B[prevChosen]) {
                    result++;
                    prevChosen = i;
                }
            }
        }
        
        System.out.println("(" + Arrays.toString(A) + "," + Arrays.toString(B) + ") => " + result);
        
        return result;
    }
	
	public static void main(String[] args) {
		MaxNonoverlappingSegments max = new MaxNonoverlappingSegments();		
		
		max.solution(new int[]{}, new int[]{});
		max.solution(new int[]{0}, new int[]{1000000000});
		max.solution(new int[]{3, 1, 5, 0, 107, 109, 10}, new int[]{100, 100, 105, 106, 108, 109, 110});
		max.solution(new int[]{0, 1, 2, 3, 4, 5}, new int[]{0, 1, 2, 3, 4, 5});
		max.solution(new int[]{0}, new int[]{0});
		max.solution(new int[]{1, 3, 7, 9, 9}, new int[]{5, 6, 8, 9, 10});
	}
}

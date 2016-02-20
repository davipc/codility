package codility.lesson8;

import java.util.Arrays;

public class Dominator {
    public int solution(int[] A) {
        int result = -1;

        // given required space complexity, cannot use a stack or a copy of input array
        // given required result (index) and space complexity (can't copy input array), cannot sort the input array

        if (A.length > 0) {
            int candidate = A[0];
            int candidateCount = 1;
            
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
            
            // if any candidates left at the end, check if it dominates the array
            if (candidateCount > 0) {
                int finalCount = 0;
                int position = -1;
                for (int i = 0; i < A.length; i++) {
                    if (candidate == A[i]) {
                        finalCount++;
                        position = i;
                    }
                }
                
                if (finalCount > A.length / 2) {
                    result = position;
                }
            }
        }
        
        System.out.println(Arrays.toString(A) + " => " + result);
        return result;
    }
    
    public static void main(String[] args) {
		Dominator d = new Dominator();
		
		d.solution(new int[]{});
		d.solution(new int[]{1});
		d.solution(new int[]{1,2});
		d.solution(new int[]{1,2,1});
		d.solution(new int[]{0,0});
		d.solution(new int[]{3,4,3,2,3,-1,3,3});
	}
}

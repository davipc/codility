package codility.test1;

import java.util.Arrays;

/**
 * 
 * Given a number X and an array A with N elements, find an index K that splits the array into two parts, where the number of occurrences of X 
 * on the first part ([0..K-1)) is equal to the number of elements distinct from X on the second part (K..N-1).
 * Consider empty arrays have a value of 0, and 0 <= K <= N.    
 * The algorithm complexity needs to be O(N), and the space complexity O(1).
 * 
 * @author Davi
 *
 */
public class Ex1 {

    public int solution(int X, int[] A) {
        int result = -1;
    	
        int N = A.length;
        
        int total;
        int currCount = 0;
        
        // first count total number of occurrences of X
        for (int i = 0; i < N; i++) {
			if (A[i] == X) {
				currCount++;
			}
		}
        
        total = currCount;
        
        // now find K
        if (total == 0) {
        	result = N;
        } else {
	        currCount = 0;
	        for (int k = 0; k < N; k++) {
				if (currCount == N-k-(total-currCount)) {
					result = k;
					break;
				}
	        	
	        	if (A[k] == X)
					currCount++;
				
			}
        }
        
        System.out.println(1 + ", " + Arrays.toString(A) + " => " + result);

        return result;
    }

	    public static void main(String[] args) {
	    	
	    	Ex1 ex1 = new Ex1();
	    	
	    	ex1.solution(1, new int[]{2});
	    	ex1.solution(1, new int[]{0});
	    	ex1.solution(1, new int[]{1});
	    	ex1.solution(1, new int[]{2,3});
	    	ex1.solution(1, new int[]{1,1});
	    	ex1.solution(5, new int[]{5,5,1,7,2,3,5});
		}

}

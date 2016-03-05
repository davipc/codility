package codility.lesson15;

import java.util.Arrays;

/**
 * WROOOOONG!
 *  
 *  This is not the solution
 *  
 * @author Davi
 *
 */
public class AbsDistinctCatterpillar {
    public int solution(int[] A) {
        int result = 0;
        
        int N = A.length;

        if (N == 1)
            result = 1;
        else {
            // CANNOT turn all elements into abs value, as abs(Integer.MIN_VALUE) is the same negative value) 
            
            int s = 0;
            int e = N-1;
            
            result = 1;
            
            while (s < e) {
                while (s < e && Math.abs((long)A[e]) >= Math.abs((long)A[s])) {
                    if (Math.abs((long)A[e]) > Math.abs((long)A[s]))
                        result++;
                    e--;
                    // if we are now in the middle of a sequence of numbers with same value, 
                    // we need to get out of the sequence (value has already been counted)
                    while (s < e && A[e] == A[e+1])
                    	e--;
                }
                while (s < e && Math.abs((long)A[s]) >= Math.abs((long)A[e])) {
                    if (Math.abs((long)A[s]) > Math.abs((long)A[e]))
                        result++;
                    s++;
                    // if we are now in the middle of a sequence of numbers with same value, 
                    // we need to get out of the sequence (value has already been counted)
                    while (s < e && A[s] == A[s-1])
                    	s++;
                }
            }
        }
        
        System.out.println(Arrays.toString(A) + " => " + result);
        
        return result;
    }
    
    public static void main(String[] args) {
		AbsDistinctCatterpillar abs = new AbsDistinctCatterpillar();
		
		abs.solution(new int[]{1});
		
		abs.solution(new int[]{-5, -3, -1, 0, 3, 6});
		
		abs.solution(new int[]{1,2,3,4,5,6});
		
		abs.solution(new int[]{-1,-1});
		
		abs.solution(new int[]{-2147483648, -1, 0, 1});
		
		abs.solution(new int[]{-5,-4,-4,-4,-4,-3,-2,-1, -1, 0, 1,2,2,2,2,3,4,4,4,4,4,4,4,5});
		
	}
}
package codility.lesson15;

import java.util.*;

public class CountTrianglesOn3 {
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
            
            while (tail <= N-2 && head <= N-1) {
                b = checkTriangle(A[i], A[tail], A[head]);
                
                if (b) {
                    result++;
                    if (head < N-1)
                        head++;
                    else {
                        tail++;
                        head = tail+1;
                    }
                } else {
                    tail++;
                    head = tail+1;
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
		CountTrianglesOn3 count = new CountTrianglesOn3();
		
		count.solution(new int[]{10,2,5,1,8,12});
		count.solution(new int[]{1,2,2,2,3,4,4});
		count.solution(new int[]{2,2,2,2,2,2,2,2});
		
		count.solution(new int[]{2,2,2,2});
		count.solution(new int[]{2,2,2,2,2});
		count.solution(new int[]{1,2,3,4,5});
	}
}

package codility.lesson15;

import java.util.Arrays;

public class CountTriangles {
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
            
            // we know that every position between tail and head will be bigger than tail, so we can just keep pushing head and 
            // adding tail-head each time it is still a triangle (as every triple starting at i and ending at head will form a triangle) 
            while (head <= N-1) {
                b = checkTriangle(A[i], A[tail], A[head]);
                
                if (b) {
                    result += head - tail;
                    head++;
                } else if (tail + 1 < head) {
                    tail++;
                } else {
                	tail++;
                	head++;
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
		CountTriangles count = new CountTriangles();
		
		count.solution(new int[]{10,2,5,1,8,12});
		count.solution(new int[]{1,2,2,2,3,4,4});
		count.solution(new int[]{2,2,2,2,2,2,2,2});
		
		count.solution(new int[]{2,2,2,2});
		count.solution(new int[]{2,2,2,2,2});
		count.solution(new int[]{1,2,3,4,5});
	}
}

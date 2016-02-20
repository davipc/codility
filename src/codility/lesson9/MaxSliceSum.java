package codility.lesson9;

import java.util.Arrays;

public class MaxSliceSum {
	public int solution(int[] A) {
        long maxEnding = Integer.MIN_VALUE;
        long maxSliceSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            maxEnding = max((long)maxEnding + (long)A[i], A[i]);
            maxSliceSum = max(maxSliceSum, maxEnding);
            //System.out.println("A[" + i + "] => " + maxEnding + ", " + maxSliceSum);
        }
        
        System.out.println(Arrays.toString(A) + " => " + maxSliceSum);
        
        return (int) maxSliceSum;
    }
    
    private long max(long i1, long i2) {
        return i1 > i2 ? i1 : i2;   
    }
    
    public static void main(String[] args) {
		MaxSliceSum mss = new MaxSliceSum();
		
		mss.solution(new int[]{1});
		mss.solution(new int[]{-3,-2,-1,-1,-1});
		mss.solution(new int[]{-2,-3,-1,5,-1,2});
		mss.solution(new int[]{0,2,1,7});
		mss.solution(new int[]{-2147483648, -1});
		mss.solution(new int[]{2147483647, 1});
		mss.solution(new int[]{-2147483648, -2147483648, -2147483648, 0});
		mss.solution(new int[]{-2147483648, -2147483648, -2147483648});
	}
}

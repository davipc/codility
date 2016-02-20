package codility.lesson9;

public class MaxDoubleSliceSum {
	public int solution(int[] A) {
        // first calculate and store the maximum slice sums ending on each index, starting from each side of the array
        // first and last values in array will never be used, so skip them (end up as 0s)
        int[] maxEndingLeft = new int[A.length];
        
        for (int i = 1; i < A.length-2; i++) {
            maxEndingLeft[i] = max(0, maxEndingLeft[i-1] + A[i]);
        }

        int[] maxEndingRight = new int[A.length];
        
        for (int i = A.length-2; i >= 2 ; i--) {
            maxEndingRight[i] = max(0, maxEndingRight[i+1] + A[i]);
        }

        // then check which sum of 2 indexes separated by a blank position is the highest
        int highest = 0;
        for (int i = 0; i < A.length-2; i++) {
            highest = max (highest, maxEndingLeft[i] + maxEndingRight[i+2]);
        }
        
        return highest;
    }
    
    private int max(int i1, int i2) {
        return i1 > i2 ? i1 : i2;
    }	    
}

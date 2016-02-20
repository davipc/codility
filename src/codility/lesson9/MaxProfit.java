package codility.lesson9;

import java.util.Arrays;

public class MaxProfit {
    public int solution(int[] A) {
        
        int maxProfitEnding = 0;
        int maxProfit = 0;
    
        // profit is 0 if bought and sold on first day... so starting with both 0 represents that
        for (int i = 1; i < A.length; i++) {
            maxProfitEnding = max(0, maxProfitEnding + (A[i] - A[i-1]));
            maxProfit = max(maxProfit, maxProfitEnding);
        }
        
        System.out.println(Arrays.toString(A) + " => " + maxProfit);
        
        return maxProfit;
    }
    
    private int max(int i1, int i2) {
        return i1 > i2 ? i1 : i2;   
    }
    
    public static void main(String[] args) {
		MaxProfit mp = new MaxProfit();
		
		mp.solution(new int[]{});
		mp.solution(new int[]{150});
		mp.solution(new int[]{150,149});
		mp.solution(new int[]{150,150});
		mp.solution(new int[]{150,151});
		mp.solution(new int[]{158,153,159,154});
		mp.solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367});
	}
    
}

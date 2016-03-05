package codility.lesson17;

import java.util.Arrays;

public class NumberSolitaire {
    public int solution(int[] A) {
        int result = 0;

        int N = A.length;
        
        int[] maxPointsPosition = new int[N];

        maxPointsPosition[0] = A[0];
        
        int max;
        for (int i = 1; i < N; i++) {
            max = Integer.MIN_VALUE;
            
            for (int j = 1; i-j >= 0 && j <= 6; j++) {
                max = Math.max(max, A[i] + maxPointsPosition[i-j]);
            }
            
            maxPointsPosition[i] = max;
        }

        result = maxPointsPosition[N-1];
        
        System.out.println(Arrays.toString(A) + " => " + result + " ; " + Arrays.toString(maxPointsPosition));
        
        return result;
    }
    
    public static void main(String[] args) {
		NumberSolitaire number = new NumberSolitaire();
		
		number.solution(new int[]{-10000, 10000});
		
		number.solution(new int[]{0, 0});
		
		number.solution(new int[]{1,2,3,4,5});
		number.solution(new int[]{1,2,-3,4,5,6});
		number.solution(new int[]{1,-2,3,-4,5,-6, 7});
		number.solution(new int[]{-1,2,3,10});
		number.solution(new int[]{1,-4,8,10000,-10000,0,0,0,0,0,0});
		number.solution(new int[]{1,-2,0,9,-1,-2});
		number.solution(new int[]{1,-2,3,-4,5,6,-7,8,-9,10,11,12,-13,14});
		number.solution(new int[]{1,-2,-3,-4,-5,6,10000,-10000,-10000,-10000,-10000,-10000,1});
		number.solution(new int[]{1,-2,-3,-4,-5,6,10000,-10000,-10000,-10000,-10000,-10000,-10000,1});
    }
    
}

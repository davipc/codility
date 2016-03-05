package codility.lesson15;

import java.util.Arrays;

public class MinAbsSumOfTwo {
	public int solution(int[] A) {
        int result = Integer.MAX_VALUE;
        
        int N = A.length;
        
        Arrays.sort(A);
        
        // if all positives, just take 2 x smallest
        if (A[0] >= 0) {
            result = 2 * A[0];
        } else 
        // if all negative, just take -2 x highest
        if (A[N-1] <= 0) {
            result = -2 * A[N-1];   
        }
        // if mix, go from extremes to middle to find smaller
        else {
            int left, right;
            left = 0;
            right = N-1;
            
            int min = Math.abs(A[left] + A[right]);
            while (left < right) {
                if (Math.abs(A[left+1] + A[right]) < Math.abs(A[left] + A[right-1]))
                    left++;
                else 
                    right--;
                
                // last calculation should be when left == right
                min = Math.min(min, Math.abs(A[left] + A[right]));
            }
            
            result = min;
        }
        
        System.out.println(Arrays.toString(A) + " => " + result);
        
        return result;
    }
	
	public static void main(String[] args) {
		MinAbsSumOfTwo min = new MinAbsSumOfTwo();
		
		min.solution(new int[]{-5});
		min.solution(new int[]{0});
		min.solution(new int[]{2});
		min.solution(new int[]{-5,-4,-1});
		min.solution(new int[]{-5,-4,-1, 0});
		min.solution(new int[]{5,4,3});
		min.solution(new int[]{5,4,3,0});
		min.solution(new int[]{-5, 4});
		min.solution(new int[]{-5, -4, 2, 3});
		min.solution(new int[]{8,7,6,5,4,-1,-9,-10});
		min.solution(new int[]{1,4,-3});
		min.solution(new int[]{-8,4,5,-10,3});
		min.solution(new int[]{-99, -50, -40, -30, 20, 60, 98});
	}
}

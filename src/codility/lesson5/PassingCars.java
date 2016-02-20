package codility.lesson5;

import java.util.Arrays;

public class PassingCars {

	public int solution(int[] A) {
        int total = 0;
        int count = 0;

        String arrayStr = Arrays.toString(A);
        
        // start counting from the right, as '1's to the right of '0's will be considered for every such '0's
        for (int i = A.length-1; i >= 0; i--) {
            // if '1', increase the count
            if (A[i] == 1) count++;
            
            // if '0', add current count to total
            if (A[i] == 0) total += count;
            
            if (total > 1000000000) {
                total = -1;
                break;
            }
        }
        
        System.out.println(arrayStr + " => " + total);
        
        return total;
    }
	
	
	public static void main(String[] args) {
		PassingCars pc = new PassingCars();

		pc.solution(new int[]{0});
		pc.solution(new int[]{1});
		pc.solution(new int[]{0,0});
		pc.solution(new int[]{1,1});
		pc.solution(new int[]{1,0});
		pc.solution(new int[]{0,1});
		pc.solution(new int[]{1,1,1,1,0});
		pc.solution(new int[]{0,1,0,1,1});
		pc.solution(new int[]{0,0,0,0,0,0,1,1});
	}	
	
}

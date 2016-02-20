package codility.lesson2;

import java.util.Arrays;

public class OddOcurrencesInArrayON2 {
	
    public int solution(int[] A) {
        int result = 0;
        
        String arrayStr = Arrays.toString(A);
        
        boolean found;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                found = false;                   
                for (int j = i+1; !found && j < A.length; j++) {
                    if(A[i] == A[j]) {
                        found = true;
                        // mark the pair "used"
                        A[i] = 0;
                        A[j] = 0;
                    }
                }
                if (!found) {
                    result = A[i];
                }
            }
        }
        
        System.out.println(arrayStr + " => " + result);
        
        return result;
    }

	public static void main(String[] args) {
		OddOcurrencesInArrayON2 cr = new OddOcurrencesInArrayON2();
		cr.solution(new int[]{1});    
		cr.solution(new int[]{1,2,1});    
		cr.solution(new int[]{1,2,1,2,3});    
		cr.solution(new int[]{1,2,3,2,3});    
		cr.solution(new int[]{1,2,1,1,2});
	}

}

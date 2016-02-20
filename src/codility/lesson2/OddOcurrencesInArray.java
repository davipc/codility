package codility.lesson2;

import java.util.Arrays;

public class OddOcurrencesInArray {
	
    public int solution(int[] A) {
        int result = 0;
        
        String arrayStr = Arrays.toString(A);
        
        Arrays.sort(A);
        
        for (int i = 0; i < A.length; i+=2) {
        	if (i == A.length-1 || A[i] != A[i+1]) {
        		result = A[i];
        		break;
        	}
        }
        
        System.out.println(arrayStr + " => " + result);
        
        return result;
    }

	public static void main(String[] args) {
		OddOcurrencesInArray cr = new OddOcurrencesInArray();
		cr.solution(new int[]{1});    
		cr.solution(new int[]{1,2,1});    
		cr.solution(new int[]{1,2,1,2,3});    
		cr.solution(new int[]{1,2,3,2,3});    
		cr.solution(new int[]{1,2,1,1,2});
	}

}

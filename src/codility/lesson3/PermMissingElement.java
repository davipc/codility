package codility.lesson3;

import java.util.Arrays;

public class PermMissingElement {
	    public int solution(int[] A) {
	        int result = 1;
	        
	        String arrayStr = Arrays.toString(A);
	        
	        Arrays.sort(A);
	        
	        for (int i = 0; i < A.length; i++) {
	            if(A[i] != i+1) {
	                result = i+1;
	                break;
	            }
	        }
	        
	        System.out.println(arrayStr + " => " + result);
	        
	        return result;
	    }
	    
	    public static void main(String[] args) {
			PermMissingElement pme = new PermMissingElement();
			
			pme.solution(new int[]{});
			pme.solution(new int[]{2});
			pme.solution(new int[]{3,1});
			pme.solution(new int[]{4,3,2});
			pme.solution(new int[]{6,3,4,5,1});
			pme.solution(new int[]{2,3,4,6,1});
		}
}

package codility.lesson12;

import java.util.*;

/**
 * Problem fixed by only doing GCD operations - not finding the factors (which can take a lot of memory for the minimal factors array)
 * @author Davi
 *
 */
public class CommonPrimeDivisors {

    public int solution(int[] A, int[] B) {
        int result = 0;
        
        int N = A.length;
        
        // for each pair of numbers A[i] and B[i]
        int a,b,gcd;
        
        boolean samePrimeDivisors;
        for (int i = 0; i < N; i++) {
        	samePrimeDivisors = true;

        	a = A[i];
            b = B[i];

            // check if same number (increases performance, and avoids trying to factor Integer.MAX_VALUE, 
            // which causes the array size limit exception) 
            if (a != b) {
	            
	            // find GCD of numbers
	            gcd = calculateGCD(a, b);
	            
	            // to avoid unnecessary calculations, check if there is no GCD and numbers are not 1 
	            if (gcd == 1) {
	            	if (a != 1 || b != 1)
	            		samePrimeDivisors = false;
	            } else {
		            // divide A and b by GCD
		            a /= gcd;
		            b /= gcd;

	            	// numbers only have the same prime factors if each number can be factored by the factors of the GCD
		            // so divide them by the factors they have in common with the common GCD until they get to 1 (or they don't have factors in common)
		            int newGcd;
		            do {
		            	newGcd = calculateGCD(a, gcd);
		            	a /= newGcd;
		            } while (newGcd != 1 && a != 1);
		            
		            if (a == 1) {
			            do {
			            	newGcd = calculateGCD(b, gcd);
			            	b /= newGcd;
			            } while (newGcd != 1 && b != 1);
		            }
		            
		            if (a != 1 || b != 1)
		            	samePrimeDivisors = false;
	            }
            }
            
            if (samePrimeDivisors)
                result++;
        }
        
        System.out.println("( " + Arrays.toString(A) + "," + Arrays.toString(B) + " ) => " + result);
        
        return result;
    }
    
	public int calculateGCD(int a, int b) {
		// need to ensure a >= b at start
		if (b > a) {
			int c = a;
			a = b;
			b = c;
		}

		return calculateGCD_recursion(a, b);
	}

	private int calculateGCD_recursion(int a, int b) {
		if (a % b == 0)
			return b;
		else
			return calculateGCD(b, a % b);
	}

	public static void main(String[] args) {
		CommonPrimeDivisors cpd = new CommonPrimeDivisors();
		
		cpd.solution(new int[]{2,1,2}, new int[]{1,2,2});
		cpd.solution(new int[]{1, 2, 2147483647}, new int[]{2147483647,2147483647,2});
		cpd.solution(new int[]{1, 3, 2147483647, 2147483647}, new int[]{2147483647,2147483647,7, 2147483647});
		
	}
	    
}

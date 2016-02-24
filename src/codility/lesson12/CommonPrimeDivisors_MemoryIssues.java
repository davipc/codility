package codility.lesson12;

import java.util.*;

/**
 * This ONLY works for numbers close to Integer.MAX_VALUE because of a couple checks placed: 
 * 	- (if a != b) 
 *  - if (gcd == 1) 
 *  
 *  without both checks, the created array could demand too much memory space, causing: 
 *  	Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
 * 
 * It does require a lot of memory though, causing the test to fail (it requires O(1) space use)
 * 
 * @author Davi
 *
 */
public class CommonPrimeDivisors_MemoryIssues {

    public int solution(int[] A, int[] B) {
        int result = 0;
        
        int N = A.length;
        
        // for each pair of numbers A[i] and B[i]
        int a,b,gcd;
        HashMap<Integer, Integer> factorsGCD;
        List<Integer> factorsGCDList, factorsA, factorsB;
        
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
		            // find GCD factors
		            factorsGCDList = factorizeNumber(gcd);
		            factorsGCD = new HashMap<Integer, Integer>();
		            for (Integer factor: factorsGCDList)
		                factorsGCD.put(factor, factor);
		            
		            // divide A and b by GCD
		            a /= gcd;
		            b /= gcd;
		            
			        // find factors of divided A and B
			        factorsA = factorizeNumber(a);
			        factorsB = factorizeNumber(b);
			
			        // check if any of the number factors cannot be found in the GCD factors
			        for (Integer factor: factorsA) {
			            if (!factorsGCD.containsKey(factor)) {
			                samePrimeDivisors = false;
			                break;
			            }
			        }
			        if (samePrimeDivisors) {
			            for (Integer factor: factorsB) {
			                if (!factorsGCD.containsKey(factor)) {
			                    samePrimeDivisors = false;
			                    break;
			                }
			            }
			        }                        
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

	public List<Integer> factorizeNumber(int N) {
		List<Integer> factors = new ArrayList<Integer>();
		
		if (N != 0) {
			
			// first find the minimal factors
			int[] minimalFactors = findMinimalFactors(N);
			int remainingNumber = N;
			int factor;
			while (remainingNumber > 1) {
				factor = minimalFactors[remainingNumber];
				if (factor == 0)
					factor = remainingNumber;
				factors.add(factor);
				remainingNumber /= factor;
			}
		}
		
		return factors;
	}
	
	private int[] findMinimalFactors(int N) {
		int[] minimalFactors = new int[N+1];
		for (int factor = 2; factor * factor <= N; factor++) {
			if (minimalFactors[factor] == 0) {
				// can also start at i*i, due to theorem
				for (int j = factor * factor; j <= N; j += factor) {
					if (minimalFactors[j] == 0)
						minimalFactors[j] = factor;
				}
			}
		}
		
		return minimalFactors;
	}

	public static void main(String[] args) {
		CommonPrimeDivisors_MemoryIssues cpd = new CommonPrimeDivisors_MemoryIssues();
		
		cpd.solution(new int[]{2,1,2}, new int[]{1,2,2});
		cpd.solution(new int[]{1, 2, 2147483647}, new int[]{2147483647,2147483647,2});
		cpd.solution(new int[]{1, 3, 2147483647, 2147483647}, new int[]{2147483647,2147483647,7, 2147483647});
		
	}
	    
}

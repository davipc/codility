package codility.lesson12;

import java.util.*;

/**
 * 
A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.

You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.

For example, given:

N = 15 and M = 75, the prime divisors are the same: {3, 5};
N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
Write a function:

class Solution { public int solution(int[] A, int[] B); }

that, given two non-empty zero-indexed arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.

For example, given:

    A[0] = 15   B[0] = 75
    A[1] = 10   B[1] = 30
    A[2] = 3    B[2] = 5
the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

Assume that:

Z is an integer within the range [1..6,000];
each element of arrays A, B is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(Z*log(max(A)+max(B))2);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * Problem fixed by only doing GCD operations - not finding the factors (which can take a lot of memory for the minimal factors array)
 * 
 * 
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

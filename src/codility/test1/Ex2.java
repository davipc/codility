package codility.test1;

import java.util.Arrays;

/**
 * 
 * Problem: given a number X represented in base -2 in the input array, where the least significant bits are to the left, find the opposite of X
 * For instance: for X = 9 (10011) (1*1 + 0*-2 + 0*4 + 1*-8 + 1*16), -X = -9 (1101) (1*1 + 1*-2 + 0*4 + 1*-8)
 * Number of bits can be up to 100,000  
 * Returned array must have the minimum amount of bits needed (only up to the last 1)
 * 
 * @author Davi
 *
 */
public class Ex2 {

	    public int[] solution(int []A) {
	        int[] result = new int[0];
	    	
	        int N = A.length; 
	        
	        if (N > 0) {
	        	// since M max is so high (100,000), we can't calculate X and find -X by using the bit representation of -X and converting to -2 base 
	        	// (for every odd element in -2 base, B[i]+B[i-1] == A[i] in base 2)

	        	// to find -X, we will use the subtraction rule for -2 base numbers (0 - bits on input number, using provided table for new bit an carry values)
	        	
	        	int[] newNumber = new int[N+1];
	        	// now do the subtraction, where we know every bit in number 0 is 0
	        	int sum;
	        	int carry = 0;
	        	for (int i = 0; i < N; i++) {
	        		if (i == N) {
	        			sum = 0;
	        		} else {
	        			sum = -A[i];
	        		}
	        		
	        		sum = carry + 0 + sum;
	        		
	        		switch (sum) {
	        			case -2:
	        				newNumber[i] = 0;
	        				carry = 1;
	        				break;
	        			case -1: 
	        				newNumber[i] = 1;
	        				carry = 1;
	        				break;
	        			case 0: 
	        				newNumber[i] = 0;
	        				carry = 0;
	        				break;
	        			case 1: 
	        				newNumber[i] = 1;
	        				carry = 0;
	        				break;
	        			case 2: 
	        				newNumber[i] = 0;
	        				carry = -1;
	        				break;
	        		}
	        	}
	        	
	        	// just in case there's an extra 1, in which case we need to add it
	        	newNumber[N] = carry;
	        	
	        	
	        	// need to return array with only up to the last "1" bit
	        	//find the last 1
	        	int last1 = -1;
	        	for (int i = newNumber.length-1; i >= 0; i--) {
	        		if (newNumber[i] == 1) {
	        			last1 = i;
	        			break;
	        		}
	        	}
	        	
	        	// create new array with only bits up to that last one (there will be at least one "1", 
	        	// as only number with only "0"s is 0 and that is covered by first if
	        	if (last1 >= 0) {
	        		// number is not 0
	        		result = new int[last1 + 1];
	        		for (int i = 0; i <= last1; i++)
	        			result[i] = newNumber[i];
	        	}
	        }
	        
	        
	        System.out.println(Arrays.toString(A) + " (" + calcBase2Neg2Number(A) + ") => " + Arrays.toString(result) + " (" + calcBase2Neg2Number(result) + ")" );

	        return result;
	    }

	    private int calcBase2Neg2Number(int[] number) {
	    	int result = 0;
	    	
	    	for (int i = 0; i < number.length; i++) {
				result += number[i] * Math.pow(-2, i);
			}
	    	
	    	return result;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	Ex2 ex1 = new Ex2();
	    	
	    	// 1
	    	ex1.solution(new int[]{1});
	    	// -1
	    	ex1.solution(new int[]{1,1});
	    	// 2
	    	ex1.solution(new int[]{0,1,1});
	    	// -2
	    	ex1.solution(new int[]{0,1});
	    	// 3
	    	ex1.solution(new int[]{1,1,1});
	    	// -3
	    	ex1.solution(new int[]{1,0,1,1});
	    	// 4
	    	ex1.solution(new int[]{0,0,1});
	    	// -4
	    	ex1.solution(new int[]{0,0,1,1});
	    	// 5
	    	ex1.solution(new int[]{1,0,1});
	    	// -5
	    	ex1.solution(new int[]{1,1,1,1});
	    	// 6
	    	ex1.solution(new int[]{0,1,0,1,1});
	    	// -6
	    	ex1.solution(new int[]{0,1,1,1});
	    	// 7
	    	ex1.solution(new int[]{1,1,0,1,1});
	    	// -7
	    	ex1.solution(new int[]{1,0,0,1});
		}

}
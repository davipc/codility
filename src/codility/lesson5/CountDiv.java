package codility.lesson5;

/**
 * 
Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within 
the range [6..11], namely 6, 8 and 10.

Assume that:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
Complexity:

expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1).
 * 
 * @author Davi
 *
 */

public class CountDiv {

    public int solution(int A, int B, int K) {
    	int result = 0;
    	
    	// is first value divisible ?
        if ( A % K == 0) { 
            ++result; 
        }

        // how many more multiples fit in the range specified?
        result += (B-A) /K;
        
		System.out.println("(" + A + ", " + B + ", " + K + ") => " + result);

		return result;
   }
	
	public static void main(String[] args) {
		CountDiv cd = new CountDiv();

		cd.solution(7, 7, 7);
		cd.solution(7, 7, 2);
		cd.solution(11, 13, 2);
		cd.solution(10, 12, 2);
		cd.solution(6, 10, 2);
		cd.solution(7, 11, 2);
		cd.solution(6, 10, 3);
		cd.solution(7, 11, 3);
	}
}

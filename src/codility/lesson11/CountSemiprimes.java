package codility.lesson11;

/**
 * 
A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. 
The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty zero-indexed arrays P and Q, each consisting of M integers. 
These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
The number of semiprimes within each of these ranges is as follows:

(1, 26) is 10,
(4, 10) is 4,
(16, 20) is 0.
Write a function:

class Solution { public int[] solution(int N, int[] P, int[] Q); }

that, given an integer N and two non-empty zero-indexed arrays P and Q consisting of M integers, returns an array consisting of M elements 
specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
the function should return the values [10, 4, 0], as explained above.

Assume that:

N is an integer within the range [1..50,000];
M is an integer within the range [1..30,000];
each element of arrays P, Q is an integer within the range [1..N];
P[i] ≤ Q[i].
Complexity:

expected worst-case time complexity is O(N*log(log(N))+M);
expected worst-case space complexity is O(N+M), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * @author Davi
 *
 */
public class CountSemiprimes {

    public int[] solution(int N, int[] P, int[] Q) {
        // first get the minimal factors for each number
        int[] minimalFactors = findMinimalFactors(N);
        
        int results[] = new int[P.length];
        
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE;
        // find min and max range boundaries
        for (int m = 0; m < P.length; m++) {
        	min = Math.min(min, P[m]);
        	max = Math.max(max, Q[m]);
        }

        // calculate accumulate number of semiprimes between min and max (numbers outside this range will be left alone)
        int countSemiprimes = 0;
        int[] semiPrimesAccummSum = new int[N+1];
        for (int i = min; i <= max; i++) {
        	if (isSemiprime(i, minimalFactors)) {
        		countSemiprimes++;
        	}
        	semiPrimesAccummSum[i] = countSemiprimes;
        }
        
        // iterate the P & Q arrays
        for (int m = 0; m < P.length; m++) {
            results[m] = semiPrimesAccummSum[Q[m]] - semiPrimesAccummSum[P[m]-1];
        }

        return results;
    }
        
    private boolean isSemiprime(int num, int[] minimalFactors) {
        boolean result = false;
        int factor = minimalFactors[num];
        if (factor != 0) {
            num /= factor;
            if (minimalFactors[num] == 0)
                result = true;
        }
        
        return result;
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
    
}

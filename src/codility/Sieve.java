package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sieve {
	
	public List<Integer> findPrimesUntilN(int N) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		if (N > 0) {
			// array that goes from 0 to N (0 will be ignored later)
			boolean[] isPrime = new boolean[N+1];
			// at first every number is prime
			Arrays.fill(isPrime,  true);
			//can stop at sqrt(N) due to theorem
			for (int i = 2; i * i <= N; i++) {
				// only need to remove multiples of prime numbers, due to theorem
				// multiples of composite numbers will have been removed previously
				if (isPrime[i]) {
					// can also start at i*i, due to theorem
					for (int j = i * i; j <= N; j += i) {
						isPrime[j] = false;
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if (isPrime[i])
					results.add(i);
			}
		}
		return results;
	}

	public List<Integer> factorizeNumber(int N) {
		List<Integer> factors = new ArrayList<Integer>();
		
		if (N != 0) {
			
			// first find the minimal factors
			int[] minimalFactors = findMinimalFactors(Math.abs(N));
			int remainingNumber = N;
			int factor;
			// if negative number, add -1 to list of factors and turn remaining number positive 
			if (remainingNumber < 0) {
				factors.add(-1);
				remainingNumber *= -1;
			}
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
		Sieve s = new Sieve();
		List<Integer> results;

		for (int i = -1; i <= 100; i++) {
			results = s.findPrimesUntilN(i);
			System.out.println(i + " => " + Arrays.toString(results.toArray(new Integer[results.size()])));
		}

		for (int i = -50; i <= 50; i++) {
			results = s.factorizeNumber(i);
			System.out.println(i + " => " + Arrays.toString(results.toArray(new Integer[results.size()])));
		}
	
	}
	
	
}

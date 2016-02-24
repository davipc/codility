package codility;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {

	public long fibonacciON(int n) {
		long result;
		if (n <= 1) {
			result = n;
		} else {
			long p2p = 0;
			long p1p = 1;
			
			long pi = 0;
			
			for (int i = 2; i <= n; i++) {
				pi = p2p + p1p;
				
				p2p = p1p;
				p1p = pi;
			}
			
			result = pi;
		}
		
		return result;
	}

	public ArrayList<Integer> getFibonacciNumbersBelowN(int N) {
		ArrayList<Integer> fib = new ArrayList<Integer>();

		fib.add(0);
		fib.add(1);
		
		int p2p = 0;
		int p1p = 1;
		int pi = 0;
		
		while (pi < N) {
			pi = p2p + p1p;
		
			if (pi < N)
				fib.add(pi);
			p2p = p1p;
			p1p = pi;
		}
		
		return fib;
	}
	
	public ArrayList<Integer> findFibonacciNumbersThatAreSumOfFibonacciNumbers(int max) {
		System.out.println("Finding fib numbers below " + max + "... ");

		long startTime = System.currentTimeMillis();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		ArrayList<Integer> fibBelowMax = getFibonacciNumbersBelowN(max);
		
		// we know the beginning of the seq is [0, 1, 1, 2,... 
		// so the third and fourth elements are the sum of the previous 2 first
		result.add(1);
		result.add(2);
		
		boolean found;
		int sum1;
		for (int num = 3; num <= max; num++) {
			found = false;
			for (int j = 0; j < fibBelowMax.size(); j++) {
				sum1 = num - fibBelowMax.get(j); 
				if (sum1 != fibBelowMax.get(j) && fibBelowMax.contains(sum1)) {
					found = true;
					break;
				}
			}
			
			if (found)
				result.add(num);
			
		}
		
		System.out.println("Took " + (System.currentTimeMillis() - startTime) + " ms");
		
		return result;
	}

	public ArrayList<Integer> findFibonacciNumbersThatAreSumOfFibonacciNumbers_QuickMoreMemory(int max) {
		System.out.println("Finding fib numbers below " + max + "  (quick) ... ");
		long startTime = System.currentTimeMillis();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		ArrayList<Integer> fibBelowMax = getFibonacciNumbersBelowN(max);
		int[] isFib = new int[max + 1];
		for (int fib: fibBelowMax) {
			isFib[fib] = 1;
		}
		
		// we know the beginning of the seq is [0, 1, 1, 2,... 
		// so the third and fourth elements are the sum of the previous 2 first
		result.add(1);
		result.add(2);
		
		boolean found;
		int sum1;
		for (int num = 3; num <= max; num++) {
			found = false;
			for (int j = 0; j < fibBelowMax.size() && fibBelowMax.get(j) <= num; j++) {
				sum1 = num - fibBelowMax.get(j); 
				if (sum1 != fibBelowMax.get(j) && isFib[sum1] == 1) {
					found = true;
					break;
				}
			}
			
			if (found)
				result.add(num);
			
		}
		
		System.out.println("Took " + (System.currentTimeMillis() - startTime) + " ms");
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " => " + f.fibonacciON(i));
		}
		System.out.println();
		
		ArrayList<Integer> found = f.findFibonacciNumbersThatAreSumOfFibonacciNumbers(1000000);
		System.out.println("Fib# that are sum of Fib# (" + found.size() + ") => " + Arrays.toString(found.toArray(new Integer[found.size()])));

		found = f.findFibonacciNumbersThatAreSumOfFibonacciNumbers_QuickMoreMemory(1000000);
		System.out.println("Fib# that are sum of Fib# (" + found.size() + ") => " + Arrays.toString(found.toArray(new Integer[found.size()])));
	
	}
}

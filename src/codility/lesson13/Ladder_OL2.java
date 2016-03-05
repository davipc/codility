package codility.lesson13;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;


public class Ladder_OL2 {
	
	public int[] solution(int[] A, int[] B) {
		int L = A.length;
		
		int[] result = new int[L];
		
		ArrayList<BigDecimal> fib = getFibonacciNumbersUntilPositionN(L + 2);
		
		for (int i = 0; i < L; i++) {
			result[i] = fib.get(A[i]+1).remainder(new BigDecimal(Math.pow(2, B[i]))).intValue();  
		}
		
		System.out.println("(" + Arrays.toString(A) + "," + Arrays.toString(B) + ") => " + Arrays.toString(result));
		
		return result;
	}
	
	public BigDecimal fibonacciON(int n) {
		BigDecimal result;
		if (n <= 1) {
			result = new BigDecimal(n);
		} else {
			BigDecimal p2p = new BigDecimal(0);
			BigDecimal p1p = new BigDecimal(1);
			
			BigDecimal pi = new BigDecimal(0);
			
			for (int i = 2; i <= n; i++) {
				pi = p2p.add(p1p);
				
				p2p = p1p;
				p1p = pi;
			}
			
			result = pi;
		}
		
		return result;
	}

	public ArrayList<BigDecimal> getFibonacciNumbersUntilPositionN(int N) {
		ArrayList<BigDecimal> fib = new ArrayList<BigDecimal>();

		fib.add(new BigDecimal(0));
		fib.add(new BigDecimal(1));
		
		BigDecimal p2p = new BigDecimal(0);
		BigDecimal p1p = new BigDecimal(1);
		BigDecimal pi;
		
		for (int i = 2; i < N; i++) {
			pi = p2p.add(p1p);
		
			fib.add(pi);
			p2p = p1p;
			p1p = pi;
		}
		
		return fib;
	}
	
	
	
	
	
	
	public long calculatePositions(int N) {
		long positions = 0;
		
		if (N <= 3)
			positions = N;
		else {
			// formula found by simulating scenarios with N from 1 to 7
			// 1 + sum(1..N/2) (N-i)!/(N-i-i)!/i!  - if even, at the end add one more (for (int)N/2 pairs, only one possible scenario)
			
			
			// climbing one step at a time is always only one way
			// after running, it's actually Fibonacci!! ==> positions = F(N+1)!
			positions++;
			
			// need to be able to calculate upto F(30000) -> numbers get too high, need to find a solution 
			for (int i = 1; i < (double)N/2; i++) {
				positions += factorial(N-i)/factorial(N-i-i)/factorial(i);
			}

			// WRONG FOR NOW
//			for (int i = 1; i < (double)N/2; i++) {
//				positions += factorialNtoMxP(N-i, N-i-i, i);
//			}
			
			if (N%2 == 0)
				positions++;
		}
		
		return positions;
	}
	
	 public long factorial(int N) {
        long multi = 1;
        for (int i = 1; i <= N; i++) {
            multi = multi * i;
        }
        return multi;
	 }

	 // WRONG
	 public long factorialNtoMxP(int N, int M, int P)
	 {
		int maxMP = Math.max(M,  P);
		int otherMP = maxMP == M ? P: M;
		
        long multi = 1;
        for (int i = N, j=0; i >= maxMP+1; i--, j++) {
            multi = multi * i;
            multi = multi / (otherMP-j > 0? otherMP-j : 1);
        }
        return multi;
	 }
	 
	 public static void main(String[] args) {
		Ladder_OL2 ladder = new Ladder_OL2();
		
		for (int i = 1; i <= 12; i++) {
			System.out.println(i + " => " + ladder.calculatePositions(i));
			// FIBONACCI!!!!!
		}
		
		System.out.println(ladder.fibonacciON(15000));
		
		ArrayList<BigDecimal> fibonacciList = ladder.getFibonacciNumbersUntilPositionN(200);
		System.out.println(Arrays.toString(fibonacciList.toArray(new BigDecimal[fibonacciList.size()])));
		
		System.out.println(fibonacciList.size());

		// should return [5,1,8,0,1]
		ladder.solution(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1});
		ladder.solution(new int[]{1}, new int[]{6});
		
		// can't really have this, since according to task description max value inside first array must be the size of the array (1 in this case)
		// for testing, can change solution code so instead of L + 2 we calculate 30000 + 2 elements in the fib array
		//ladder.solution(new int[]{30000}, new int[]{6});
		
//		// sending big array for testing
//		int[] A = new int[30000];
//		int[] B = new int[30000];
//		for (int i = 1; i <= 30000; i++) {
//			A[i-1] = i;
//			B[i-1] = i%31;
//		}
//		ladder.solution(A, B);
	}
	 
}

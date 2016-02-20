package codility.lesson10;

import java.util.*;

public class Peaks {

	public int solution(int[] A) {
        int result = 0;
    
        int N = A.length;

        System.out.println("In" + Arrays.toString(A) + "; N = " +N);
        
        // mark accumulated peaks
        int[] peaks = new int[N];
        int count = 0;
        for (int i = 1; i < N -1; i++) {
            if (A[i-1] < A[i] && A[i+1] < A[i])
                count++;    
            peaks[i] = count;
        }
        // set peaks count on last elem as it will be needed during div checks
        peaks[N-1] = count;
        
        System.out.println("Peaks: " + Arrays.toString(peaks));
        
        // check count
        if (count > 0) {
            // if only one peak, will need the whole array
            if (count == 1)
                result = 1;
            else {

            	// at this point (peaks > 1) we know at least the single group will satisfy the criteria
            	// so set result to 1, then check for bigger numbers of groups
            	result = 1;
            	
            	// for each divisor of N, check if that number of groups work
                Integer[] divisors = getDivisors(N);
                
                // result will be at least 1 at this point
                boolean candidate;
                int divisor, startIdx, endIdx;
                // check from top value to bottom - stop when one is found
                // for div 1 we know num groups is 1, and we already know that is the minimum. No need to check.
                // for div = N we know it's impossible, as all elements would have to be peaks (impossible by definition)
                for (int i = divisors.length-2; i > 0; i--) {
                    candidate = true;
                    divisor = divisors[i];
                    
                    System.out.println("Checking div = " + divisor);
                    
                    for (int j = 0; j < N; j+= N/divisor) {
                        startIdx = (j == 0 ? j : j-1);
                        endIdx = j + N/divisor-1;
                        
                        if (peaks[startIdx] == peaks[endIdx]) {
                            candidate = false;
                            break;
                        }
                    }
                    
                    // if all groups had at least 1 peak, this is the result!
                    if (candidate) {
                        result = divisor;
                        break;
                    }
                }
                
            }
        }
                      
        System.out.println("Result -> " + result);
        System.out.println();
        
        return result;
    }
    
    private Integer[] getDivisors(int N) {
        Set<Integer> set = new TreeSet<Integer>();
        
        double sqrt = Math.sqrt(N);
        int i = 1;
        for (; i < sqrt; i++) {
            if (N % i == 0) {
                set.add(i); 
                set.add(N/i);
            }
        }
        if (i * i == N)
            set.add(i);
            
        return set.toArray(new Integer[]{});
    }
    
    
    public static void main(String[] args) {
		Peaks p = new Peaks();
		p.solution(new int[]{1});
		p.solution(new int[]{1,2,1});
		p.solution(new int[]{1,2,1,1,1});
		p.solution(new int[]{1,2,3,4,5,6,5});
		p.solution(new int[]{1,2,3,4,5,6,5,4,3,2,1});
		p.solution(new int[]{1,4,3,4,5,5,5,4,3,2,1,2,3});
		p.solution(new int[]{1,4,3,4,5,5,5,4,3,2,1,2,3,4,5,6,7});
		p.solution(new int[]{1,4,3,4,5,5,5,4,3,2,1,2,3,4,5,6,7,8,9});
		p.solution(new int[]{1,2,3,4,5,5,5,4,3,2,1,2,3,4,5,6,7,9,8,10,9});
	}
}

package codility.lesson11;

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

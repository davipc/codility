package codility;

public class Combinations {

    public int calculateNumCombinations(int n, int r) {
    	int combinations = 1;

    	int maxDivisor = Math.max(n-r, r);
    	int minDivisor = Math.min(n-r, r);
    	
    	for (int i = n; i >= maxDivisor+1; i--) {
    		combinations *= i;
    	}
    	
    	for (int i = 2; i <= minDivisor; i++) {
    		combinations /= i;
    	}
    	
    	return combinations;
    }
	
}

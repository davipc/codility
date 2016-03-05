package codility.lesson15;

public class CountDistinctSlicesEasierFormula {
	
    public int solution(int M, int[] A) {
        int result = 0;
        
        long bigResult = 0;
        
        int N = A.length;
        
        boolean[] seen = new boolean[M+1];
        
        int head = 0;
        int tail = 0;
        
        while (head < N) {
            // advance head
            // found that the number of new sub-slices to add is equal to front-back+1 
        	// (add on every step, instead of once every big slice is found as in the other solution)
            while (head < N && !seen[A[head]]) {
                bigResult += head - tail + 1;
                seen[A[head]] = true;
                head++;

                if (bigResult > 1000000000) {
                    bigResult = 1000000000;
                    break;
                }
            }
                        
            // found recurrence of number

            // now advance tail until there are no more repeats
            while (head < N && tail < head && seen[A[head]]) {
                seen[A[tail]] = false;
                tail++;
            }
        }
        
        result = (int) bigResult;

        System.out.println("Result => " + result);
        
        return result;
    }
	
	public static void main(String[] args) {
		CountDistinctSlicesEasierFormula count = new CountDistinctSlicesEasierFormula();

		count.solution(100, new int[]{100});
		count.solution(6, new int[]{3,4,5,5,2});
		
		
		// big range test
		int[] A = new int[100000];
		
		for (int i = 1; i <= A.length; i++) {
			A[i-1] = i;
		}
		
		count.solution(100000, A);
	}
}

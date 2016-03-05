package codility.lesson16;

import java.util.Arrays;

public class TieRopes {

	public int solution(int K, int[] A) {
        int result = 0;
        
        int N = A.length;
        
        // just for printing at the end
        String arrStr = Arrays.toString(A);
        
        // if only one knot, return 1 if size >= k, 0 otherwise
        if (N == 1)
            result = A[0] >= K ? 1 : 0;
        else {
            for (int i = 0; i < N-1; i++) {
                if (A[i] < K) {
                    A[i+1] += A[i];
                    A[i] = 0;
                }
            }
            
            // all tying is done. Now count knots for which size > K
            for (int i = 0; i < N; i++) {
                if (A[i] >= K)
                    result++;
            }
        }        
        
        System.out.println("(" + K + ", " + arrStr + ") => " + result + " ; " + Arrays.toString(A));
        return result;
    }
	
	public static void main(String[] args) {
		TieRopes tie = new TieRopes();
		
		tie.solution(4, new int[]{3});
		tie.solution(1000000000, new int[]{1000000000});
		tie.solution(1000000000, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 23, 1, 1, 1});
		tie.solution(1, new int[]{4, 1, 2, 5, 2, 1000000000, 6, 7, 2, 4, 3});
		tie.solution(10, new int[]{1, 5, 4, 2, 4, 10});
		tie.solution(10, new int[]{1, 10, 9, 2, 8});
		tie.solution(10, new int[]{10, 1, 10, 1, 2, 3, 4});
		tie.solution(4, new int[]{1, 2, 3, 4, 1, 1, 3});
	}
}

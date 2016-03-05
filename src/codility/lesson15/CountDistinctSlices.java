package codility.lesson15;

public class CountDistinctSlices {
	
    public int solution(int M, int[] A) {
        int result = 0;
        
        long bigResult = 0;
        
        int N = A.length;
        
        int[] numAmounts = new int[M+1];
        
        int head = 0;
        int tail = 0;
        int prevHead = 0;
        
        while (head < N) {
            // store this, will be needed when calculating intersecting slices
            prevHead = head;
            
            // advance head   
            while (head < N && numAmounts[A[head]] == 0) {
                numAmounts[A[head]]++;
                head++;
            }
                        
            // found recurrence of number
            // compute new total and go find next big slice with no recurrences
            // number of slices in slice from tail to head is N*(N+1)/2
            bigResult += (long)(head - tail) * (long)(head - tail + 1) / 2;
            
            // this will be an intersection, need to sub from result
            if (prevHead > tail) {
                bigResult -= (long)(prevHead-tail) * (long)(prevHead-tail + 1)/2;
            }

            if (bigResult > 1000000000) {
                bigResult = 1000000000;
                break;
            }
                        
            // now advance tail until there are no more repeats
            while (head < N && tail < head && numAmounts[A[head]] > 0) {
                numAmounts[A[tail]]--;
                tail++;
            }
        }
        
        result = (int) bigResult;

        System.out.println("Result => " + result);
        
        return result;
    }
	
	public static void main(String[] args) {
		CountDistinctSlices count = new CountDistinctSlices();

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

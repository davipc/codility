package codility.lesson5;

public class CountDiv {

    public int solution(int A, int B, int K) {
    	int result;
    	
    	int offsetForLeftRange = 0;
        if ( A % K == 0) { 
            ++offsetForLeftRange; 
        }

        result = (B/K) - (A /K) + offsetForLeftRange;
        
		System.out.println("(" + A + ", " + B + ", " + K + ") => " + result);

		return result;
   }
	
	public static void main(String[] args) {
		CountDiv cd = new CountDiv();

		cd.solution(11, 13, 2);
	}
}

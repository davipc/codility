package codility.lesson1;

/**
 * Solution is log(N) because bin representation of integer value is log(N) 
 */
public class BinaryGapBitwiseOperations {

	    public int solution(int N) {
	        boolean counting = false;
	        int currBit; 
	        int previousBit = -1;
	        int maxSize = 0;
	        int size = 0;
	        for (int remaining = N; remaining > 0; remaining >>= 1) {
	            currBit = remaining & 1;

	            // 10
	            if (previousBit == 1 && currBit == 0) {
	                // if 0 is found after a 1, start counting
	                counting = true;
	                size++;
	            } else 
	            // 10 or 00
	            if (counting && currBit == 0) {
	                // just add 1 to size
	                size++;
	            } else 
	            // 01
	            if (counting && currBit == 1) {
	                // finish counting
	                if (size > maxSize) {
	                    maxSize = size;
	                }
	                counting = false;
	                size = 0;
	            } else {
	                // 11
	                // do nothing
	            }
	            
	            previousBit = currBit;
	            
	        }


	        System.out.println(N + " -> binary string: " + Integer.toBinaryString(N) + "; size: " + maxSize);
	       	        
	        return maxSize;
	    }

	    public static void main(String[] args) {
	    	
	    	BinaryGapBitwiseOperations bg = new BinaryGapBitwiseOperations();
	    	
	    	bg.solution(328);
	    	bg.solution(1162);
	    	
		}

}

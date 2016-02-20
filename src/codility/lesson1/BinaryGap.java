package codility.lesson1;

// you can also use imports, for example:
public class BinaryGap {

	    public int solution(int N) {
	        String binStr = Integer.toBinaryString(N);
	        
	        
	        
	        boolean counting = false;
	        char currChar; 
	        char previousChar = '.';
	        int maxSize = 0;
	        int size = 0;
	        for (int i = 0; i < binStr.length(); i++) {
	            currChar = binStr.charAt(i);

	            // 10
	            if (previousChar == '1' && currChar == '0') {
	                // if 0 is found after a 1, start counting
	                counting = true;
	                size++;
	            } else 
	            // 10 or 00
	            if (counting && currChar == '0') {
	                // just add 1 to size
	                size++;
	            } else 
	            // 01
	            if (counting && currChar == '1') {
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
	            
	            previousChar = currChar;
	        }


	        System.out.println(N + " -> binary string: " + binStr + "; size: " + maxSize);
	       	        
	        return maxSize;
	    }

	    public static void main(String[] args) {
	    	
	    	BinaryGap bg = new BinaryGap();
	    	
	    	bg.solution(328);
	    	bg.solution(1162);
	    	
		}

}

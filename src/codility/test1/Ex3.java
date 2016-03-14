package codility.test1;


/**
 * 
 * Problem: A knight is positioned at square (0,0) in an infinite sized chess board. 
 * Calculate how many moves will be necessary to move the knight to position (X,Y).
 * 
 * @author Davi
 *
 */
public class Ex3 {

	    public int solution(int X, int Y) {
	        int result = -1;
	    	
	        
	        System.out.println("(" + X + "," + Y + ") => " + result + " moves");

	        return result;
	    }

	    public static void main(String[] args) {
	    	
	    	Ex3 ex1 = new Ex3();
	    	ex1.solution(0, 0);
		}

}

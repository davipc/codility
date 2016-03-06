package codility.lesson10;

/**
 * 
An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

(1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Assume that:

N is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(sqrt(N));
expected worst-case space complexity is O(1).
 * 
 * @author Davi
 *
 */
public class MinPerimeterRectangle {

	public int solution(int N) {
        int result = Integer.MAX_VALUE;
        
        double sqrt = Math.sqrt(N);
        
        int i = 1;
        for (; i <= sqrt; i++) {
            if (N % i == 0) {
                result = Math.min(result, 2*(i+N/i));
            }
        }
        
        System.out.println(N + " => " + result);
        
        return result;
    }
	
	public static void main(String[] args) {
		MinPerimeterRectangle mpr = new MinPerimeterRectangle();
		
		mpr.solution(1);
		mpr.solution(2);
		mpr.solution(3);
		mpr.solution(4);
		mpr.solution(5);
		mpr.solution(6);
		mpr.solution(7);
		mpr.solution(8);
		mpr.solution(9);
		mpr.solution(10);
		mpr.solution(11);
		mpr.solution(12);
		mpr.solution(13);
		mpr.solution(14);
		mpr.solution(15);
		mpr.solution(30);
		mpr.solution(1000000000);
	}
}

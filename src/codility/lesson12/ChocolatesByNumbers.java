package codility.lesson12;

/**
 * 
Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

You stop eating when you encounter an empty wrapper.

For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

The goal is to count the number of chocolates that you will eat, following the above rules.

Write a function:

class Solution { public int solution(int N, int M); }

that, given two positive integers N and M, returns the number of chocolates that you will eat.

For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

Assume that:

N and M are integers within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(log(N+M));
expected worst-case space complexity is O(log(N+M)).
 * 
 * @author Davi
 *
 */
public class ChocolatesByNumbers {
	public int solution(int N, int M) {
		int result = 1;

		// if numbers cannot be further divided by a common divisor, all chocolates will be eaten on that reduced N
		// for instance, (10,4) can be reduced to (5,2), but not further, and then result would be 5
		// whenever a reduced form is reached, the reduced number of chocolates will always be eaten (5,1 == 5,2 == 5,3 == 5,4)  
		// same for (4,10): it can be reduced to (2,5), but not further, and then result would be 2
		//
		// another way of doing this is: a position will only be reached again when the LMC is reached - on that occasion, the number of moves 
		// up to that point (chocolates eaten) will be = LCM / step size - for instance, for (10,4): LCM = 20, result = 20/4 = 5    
		int gcd = calculateGCD(N, M);

		result = N / gcd;

		System.out.println("(" + N + ", " + M + ") => " + result);
		return result;
	}

	public int calculateGCD(int a, int b) {
		// need to ensure a >= b at start
		if (b > a) {
			int c = a;
			a = b;
			b = c;
		}

		return calculateGCD_recursion(a, b);
	}

	private int calculateGCD_recursion(int a, int b) {
		if (a % b == 0)
			return b;
		else
			return calculateGCD(b, a % b);
	}
	
	
	public static void main(String[] args) {
		ChocolatesByNumbers choc = new ChocolatesByNumbers();
		
		choc.solution(1,1);
		choc.solution(2,1);
		choc.solution(4,2);
		choc.solution(5,2);
		choc.solution(7,3);
		choc.solution(24,12);
		choc.solution(24,16);
		choc.solution(1,2);
		choc.solution(2,3);
		choc.solution(5,11);
		choc.solution(5,10);
		choc.solution(14,21);
		choc.solution(6, 153);
	}
	
}

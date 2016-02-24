package codility.lesson12;

public class ChocolatesByNumbers {
	public int solution(int N, int M) {
		int result = 1;

		// if numbers cannot be further divided by a common divisor, all chocolates will be eaten on that reduced N
		// for instance, (10,4) can be reduced to (5,2), but not further, and then result would be 5
		// same for (4,10): it can be reduced to (2,5), but not further, and then result would be 4
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

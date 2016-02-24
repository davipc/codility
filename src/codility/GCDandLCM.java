package codility;


public class GCDandLCM {

	/**
	 * Calculates and returns the Greater Common Divisor of 2 numbers (MDC - Maximo Divisor Comum)
	 * @param a
	 * @param b
	 * @return
	 */
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
	
	/**
	 * Calculates and returns the Least Common Multiple of 2 numbers (MMC - Minimo Multiplo Comum)
	 * @param a
	 * @param b
	 * @return
	 */
	public int calculateLCM(int a, int b) {
		int gcd = calculateGCD(a, b);
		
		return a*b/gcd;
	}

	
	private void calculateGCDandLCM(int a, int b) {
		System.out.println("(" + a + ", " + b + ") => GCD = " + calculateGCD(a,b) + ", LCM = " + calculateLCM(a, b) );
	}
	
	public static void main(String[] args) {
		GCDandLCM calc = new GCDandLCM();
		
		calc.calculateGCDandLCM(1, 1);
		calc.calculateGCDandLCM(2, 8);
		calc.calculateGCDandLCM(6, 5);
		calc.calculateGCDandLCM(16, 24);
		calc.calculateGCDandLCM(15, 50);
		calc.calculateGCDandLCM(190, 28);
	}
}

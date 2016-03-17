package techinterview;

/**
 * 

Devise a function that takes an input 'n' (integer) and returns a string that is the
decimal representation of the number grouped by commas after every 3 digits. Do not
solve the task using a built-in formatting function that can accomplish the whole
task on its own.

Assume: 0 <= n < 1000000000

1 -> "1"
10 -> "10"
100 -> "100"
1000 -> "1,000"
10000 -> "10,000"
100000 -> "100,000"
1000000 -> "1,000,000"
35235235 -> "35,235,235"
999999999 -> "999,999,999"

 * 
 * @author Davi
 *
 */
public class WithCommas {
	
	// string solution
	public static String formatWithCommas(int n) {
		String result = "";
		
		String numberWithoutCommas = Integer.toString(n);
		
		
		if (numberWithoutCommas.length() > 3) {
			int firstDigits = numberWithoutCommas.length() % 3;
			int numGroups = numberWithoutCommas.length() / 3;
			
			result = numberWithoutCommas.substring(0, firstDigits);
			
			
			for (int i = 0; i < numGroups; i++) {
				result += (result.length() > 0 ? "," : "") + numberWithoutCommas.substring(firstDigits+i*3, firstDigits+i*3+3);
			}
				
		} else {
			result = numberWithoutCommas;
		}
		
		System.out.println(n + " => " + result);
		return result;
	}
	
	// numeric solution
	public static String formatWithCommas2(int n) {
		String result = "";
		
		int div = n;
		int remainder;
		int digits = 0;
		
		do {
			remainder = div % 10;
			div = div / 10;
			
			digits++;
			result = remainder + (digits >= 4 && digits % 3 == 1 ? ",":"") + result; 
		} while (div > 0);
		
		System.out.println(n + " => " + result);
		return result;
	}

	
	public static void main(String[] args) {
		formatWithCommas(1);
		formatWithCommas(10);
		formatWithCommas(100);
		formatWithCommas(1000);
		formatWithCommas(10000);
		formatWithCommas(100000);
		formatWithCommas(1000000);
		formatWithCommas(35235235);
		formatWithCommas(999999999);

		formatWithCommas2(1);
		formatWithCommas2(10);
		formatWithCommas2(100);
		formatWithCommas2(1000);
		formatWithCommas2(10000);
		formatWithCommas2(100000);
		formatWithCommas2(1000000);
		formatWithCommas2(35235235);
		formatWithCommas2(999999999);
	
	}
}

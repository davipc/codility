package codility.lesson10;

public class CountFactors {

	/**
	 * 
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(sqrt(N));
expected worst-case space complexity is O(1).

	 * 
	 * 
	 * 
	 * For each divisor found there is also a symmetric divisor (for instance, N=6, divisor 2 has symmetric 3)
	 * So, every time we find a divisor below sqrt(N), we also count the symmetric one. If symmetric is the same as 
	 * the divisor itself, count only once (when the divisor is the same as sqrt(N))
	 *  
	 * @param N
	 * @return
	 */
	 public int solution(int N) {
        int result = 0;

        double sqr = Math.sqrt(N);
        
        int i = 1;
        for (; i < sqr; i++) {
            if (N % i == 0) {
                result += 2;
            }
        }
        
        if (i * i == N)
            result += 1;
        
        System.out.println(N + " => " + result);
        
        return result;
    }
	
	public static void main(String[] args) {
		CountFactors cf = new CountFactors();
		
		cf.solution(1);
		cf.solution(2);
		cf.solution(3);
		cf.solution(4);
		cf.solution(5);
		cf.solution(6);
		cf.solution(7);
		cf.solution(8);
		cf.solution(9);
		cf.solution(10);
		cf.solution(11);
		cf.solution(12);
		cf.solution(13);
		cf.solution(14);
		cf.solution(15);
		cf.solution(24);
		cf.solution(2147483647);
	}
}

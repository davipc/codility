package codility.lesson10;

public class CountFactors {

	/**
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

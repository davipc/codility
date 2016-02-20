package codility.lesson10;

public class MinPerimeterRectangle {

	public int solution(int N) {
        int result = Integer.MAX_VALUE;
        
        double sqrt = Math.sqrt(N);
        
        int i = 1;
        for (; i < sqrt; i++) {
            if (N % i == 0) {
                result = Math.min(result, 2*(i+N/i));
            }
        }
        
        if (i * i == N) {
            result = Math.min(result, 2*(i+N/i));
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

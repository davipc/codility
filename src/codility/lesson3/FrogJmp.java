package codility.lesson3;

public class FrogJmp {
    public int solution(int X, int Y, int D) {

        int jumps = (int) Math.ceil( (Y - X) / (double)D );
        
        System.out.println("[X, Y, D] = [" + X + ", " + Y + ", " + D + "] => " + jumps);

        return jumps;
    }
    
	public static void main(String[] args) {
		FrogJmp fj = new FrogJmp();
		fj.solution(0,0,1);    
		fj.solution(0,1,1);    
		fj.solution(4,10,2);    
		fj.solution(4,10,6);    
	}
    

}

package codility.lesson15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {
	public int solution(int[] A) {
        int result;
		
		Set<Integer> uniqueNbrs = new HashSet<Integer>();
        
        for (int a: A) {
            uniqueNbrs.add((int)Math.abs(a));
        }
        
        result = uniqueNbrs.size();
        
        System.out.println(Arrays.toString(A) + " => " + result);
        return result; 
    }
	
	public static void main(String[] args) {
		AbsDistinct dist = new AbsDistinct();
		
		dist.solution(new int[]{});
		dist.solution(new int[]{1});
		dist.solution(new int[]{1,-1,-1});
		dist.solution(new int[]{1,2,-1});
		dist.solution(new int[]{-1,3});
		dist.solution(new int[]{-3,1,-3,1});
	}
}

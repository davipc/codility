package codility.lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
	public int solution(int[] A) {
        int result = 0;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        
        result = set.size();
        
        return result;
    }
}

package codility.lesson4;

// you can also use imports, for example:
import java.util.*;

public class FrogRiverOne {


    public int solution(int X, int[] A) {
        int result = -1;
        
        Set<Integer> s = new TreeSet<Integer>();
        
        for (int i = 1; i <= X; i++) {
            s.add(i);
        }
        
        for (int i = 0; i < A.length; i++) {
            s.remove(A[i]);
            
            if (s.isEmpty()) {
                result = i;
                break;
            }
        }
        
        return result;
    }
}

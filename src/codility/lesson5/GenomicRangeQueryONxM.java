package codility.lesson5;

public class GenomicRangeQueryONxM {

    public int[] solution(String S, int[] P, int[] Q) {
        int[] results = new int[P.length];
        
        char[] sArr = S.toCharArray();
        
        // for each query to execute
        int min;
        int impact;
        for (int i = 0; i < P.length; i++) {
            min = 4;
            for (int j = P[i]; j <= Q[i]; j++) {
                
                switch(sArr[j]) { 
                    case 'A': impact = 1; break;
                    case 'C': impact = 2; break;
                    case 'G': impact = 3; break;
                    case 'T': impact = 4; break;
                    default: impact = 0;
                }
                
                if (impact < min)
                    min = impact;
                
                // no reason to keep looking if already lowest possible
                if (min == 1)
                    break;
            }
            
            results[i] = min;
        }
        
        return results;
    }
}

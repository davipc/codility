package codility.lesson5;

import java.util.Arrays;

public class GenomicRangeQuery {
	public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        
        int[] genASum = new int[S.length()+1]; 
        int[] genCSum = new int[S.length()+1]; 
        int[] genGSum = new int[S.length()+1]; 

        genASum[0] = genCSum[0] = genGSum[0] = 0;

        // sum the occurrences of each nucleotide  
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            
            genASum[i+1] = genASum[i];
            genCSum[i+1] = genCSum[i];
            genGSum[i+1] = genGSum[i];
            
            switch(c) {
                case 'A': genASum[i+1]++; break;   
                case 'C': genCSum[i+1]++; break;   
                case 'G': genGSum[i+1]++; break;   
                default: break;
            }
        }
        
        int fromIndex, toIndex;
        for (int i = 0; i < P.length; i++) {
            fromIndex = P[i];
            toIndex = Q[i]+1;
            
            if (genASum[toIndex] - genASum[fromIndex] > 0) {
                result[i] = 1;   
            } else if (genCSum[toIndex] - genCSum[fromIndex] > 0) {
                result[i] = 2;   
            } else if (genGSum[toIndex] - genGSum[fromIndex] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }
        
        System.out.println("\"" + S + "\" " + Arrays.toString(P) + " " + Arrays.toString(Q) + " => " + Arrays.toString(result));
        return result;

    }
	
	public static void main(String[] args) {
		GenomicRangeQuery grq = new GenomicRangeQuery();
		
		grq.solution("ACG", new int[]{0,1}, new int[]{1,1});
		
		
	}
	
}

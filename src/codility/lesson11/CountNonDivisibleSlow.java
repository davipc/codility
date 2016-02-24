package codility.lesson11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class CountNonDivisibleSlow {
	
	public int[] solution(int[] A) {
		int N = A.length;
		int[] result = new int[N];
		
		// count the number of entries per number, and order them in another structure
		HashMap<Integer, Integer> numberCounts = new HashMap<Integer, Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>();
		Integer currCount;
		for (int i: A) {
			currCount = numberCounts.get(i);
			if (currCount == null)
				currCount = 1;
			else 
				currCount++;
			numberCounts.put(i, currCount);
			set.add(i);
		}
		
		Integer[] orderedNumbers = set.toArray(new Integer[set.size()]);
		int[] counts = new int[2 * N + 1];
		int numberCount;
		for (int i = 0; i < orderedNumbers.length; i++) {
			numberCount = numberCounts.get(orderedNumbers[i]);
			counts[orderedNumbers[i]] += numberCount-1; 
			for (int j = i+1; j < orderedNumbers.length; j++) {
				if (orderedNumbers[j] % orderedNumbers[i] == 0)
					counts[orderedNumbers[j]] = counts[orderedNumbers[j]] + numberCount; 
			}
		}

		for (int i = 0; i < N; i++) {
			result[i] = N - 1 - counts[A[i]];
		}

		System.out.println(Arrays.toString(A) + " => " + Arrays.toString(result));
		
		return result;
	}

	public static void main(String[] args) {
		CountNonDivisibleSlow cnd = new CountNonDivisibleSlow();
		cnd.solution(new int[]{2,1,3});
		//cnd.solution(new int[]{3,1,2,3,6});
	}
}

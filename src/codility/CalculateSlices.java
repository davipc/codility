package codility;
import java.util.Arrays;


public class CalculateSlices {

	// O(n3)
	public long calculateMaxSliceSum1(int []A) {
		long max = 0;
		int sum;
		
		System.out.println(Arrays.toString(A));
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				sum = 0;
				for (int k = i; k <= j; k++)
					sum += A[k];
				System.out.println("sum1[" + i + "," + j + "] = " + sum);
				max = max(sum, max);
			}
		}

		System.out.println("Max: " + max);
		return max;
	}
	
	
	// O(n2) - will return 0 if all slices add up to negative value, meaning empty slice
	public long calculateMaxSliceSum2(int []A) {
		long max = 0;
		int sum;
		int previousSum;

		System.out.println(Arrays.toString(A));
		for (int i = 0; i < A.length; i++) {
			sum = previousSum = 0;
			for (int j = i; j < A.length; j++) {
				sum = previousSum + A[j];
				previousSum = sum;
				System.out.println("sum2[" + i + "," + j + "] = " + sum);
				max = max(sum, max);
			}
		}
		
		System.out.println("Max: " + max);
		return max;
	}
	
	// O(n) - for this to work we need to assume max slice adds up to at least 0 (empty slice)
	public long calculateMaxSliceSum3(int []A) {
		long maxEnding = 0;
		long maxSlice = 0;

		System.out.println(Arrays.toString(A));
		for (int i = 0; i < A.length; i++) {
			// if negative turns max ending on this element negative, further max's wont count with it (by going back to 0)
			maxEnding = max(0, maxEnding+A[i]);
			maxSlice = max (maxSlice, maxEnding);
			System.out.println("Max Ending: " + maxEnding + "; MaxSlice: " + maxSlice );
		}
		
		System.out.println("Max: " + maxSlice);
		return maxSlice;
	}
	
	private long max(long i1, long i2) {
		return (i1 > i2 ? i1 : i2);
	}
	
	public static void main(String[] args) {
		CalculateSlices t = new CalculateSlices();

		int[] A = new int[]{1,2,3,4};
		t.calculateMaxSliceSum1(A);
		System.out.println();
		t.calculateMaxSliceSum2(A);
		System.out.println();
		t.calculateMaxSliceSum3(A);
		System.out.println();
		
		A = new int[]{2,-3,1};
		t.calculateMaxSliceSum1(A);
		System.out.println();
		t.calculateMaxSliceSum2(A);
		System.out.println();
		t.calculateMaxSliceSum3(A);
		System.out.println();
		
		A = new int[]{2,-3,3,1};
		t.calculateMaxSliceSum1(A);
		System.out.println();
		t.calculateMaxSliceSum2(A);
		System.out.println();
		t.calculateMaxSliceSum3(A);
		System.out.println();

		A = new int[]{-1,-3,-2};
		t.calculateMaxSliceSum1(A);
		System.out.println();
		t.calculateMaxSliceSum2(A);
		System.out.println();
		t.calculateMaxSliceSum3(A);
		System.out.println();
	}
	
}

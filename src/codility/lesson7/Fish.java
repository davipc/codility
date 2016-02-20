package codility.lesson7;

import java.util.Arrays;
import java.util.Stack;

public class Fish {
	public int solution(int[] A, int[] B) {
		int result = 0;

		boolean debugEnabled = false;

		Stack<Integer> alive = new Stack<Integer>();
		boolean zeroWins;
		int otherFishIdx = -1;

		for (int i = 0; i < A.length; i++) {
			zeroWins = true;

			// if downstream, just push the fish into the stack
			if (B[i] == 1) {
				if (debugEnabled)
					System.out.println(A[i] + " -> just pushed");
				alive.push(i);
			}
			// if upstream, check if there were fishes coming downstream
			else {
				if (!alive.empty())
					otherFishIdx = alive.peek();

				// while fishes come from the oposite direction and current fish
				// is bigger, he keeps eating them
				while (!alive.empty() && B[otherFishIdx] == 1 && zeroWins) {
					if (debugEnabled)
						System.out.print("FIGHT => ");
					if (A[i] > A[otherFishIdx]) {

						if (debugEnabled)
							System.out.println(A[i] + " -> eats <- " + A[otherFishIdx]);

						// eat other fish
						alive.pop();

						// get the idx of the next fish to check
						if (!alive.empty())
							otherFishIdx = alive.peek();
					} else {
						if (debugEnabled)
							System.out.println(A[otherFishIdx] + " <- eats -> " + A[i]);

						zeroWins = false;
					}
				}

				// eating finished (if any)
				// if zero ate every one coming on contrary direction, push
				// it... otherwise do nothing
				if (zeroWins) {
					if (debugEnabled)
						System.out.println("FIGHT OVER, " + A[i] + " survived, added to stack");
					alive.push(i);
				} else {
					if (debugEnabled)
						System.out.println("FIGHT OVER, " + A[i] + " DIDNT survive, NOT added to stack");

				}
			}
		}

		// count survivors
		result = alive.size();

		System.out.println(Arrays.toString(A) + ", " + Arrays.toString(B) + " => " + result);
		
		return result;
	}

	public static void main(String[] args) {
		Fish f = new Fish();

		f.solution(new int[] { 1 }, new int[] { 0 });
		f.solution(new int[] { 1000 }, new int[] { 1 });
		f.solution(new int[] { 1, 1000, 2, 5, 9, 999 }, new int[] { 0, 1, 1, 0,1, 0 });
		f.solution(new int[] { 1, 2, 3, 4, 5 }, new int[] { 0, 0, 0, 0, 0 });
		f.solution(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 1, 1, 1, 1 });
		f.solution(new int[] { 5, 4, 3, 2, 1 }, new int[] { 0, 0, 0, 0, 1 });
		f.solution(new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 0, 0, 0, 0 });
		f.solution(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 1, 1, 1, 0 });
		f.solution(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 1, 0, 0, 0 });
	}
}

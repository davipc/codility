package codility.lesson7;

import java.util.Arrays;
import java.util.Stack;

public class StoneWall {
	public int solution(int[] H) {
        int result = 0;
        
        Stack<Integer> heights = new Stack<Integer>();
        
        for (int i = 0; i < H.length; i++) {
            result += popRectangles(heights, H[i]);
            
            // in any case, push the new height to the stack
            heights.push(H[i]);
        }

        // finally add heights still in queue (considering adjascent ones with same height as one) 
        result += popRectangles(heights, 0);
        
        System.out.println(Arrays.toString(H) + " => " + result);
        
        return result;
    }
    
    private int popRectangles(Stack<Integer> heights, int newHeight) {
        int count = 0;

        // while the stack has heights to check and the new height is lower than previously
        while (!heights.empty() && newHeight < heights.peek()) {
            // remove all contiguous heights with same value (will be a single rectangle)
            int popped = heights.pop();
            while (!heights.empty() && popped == heights.peek()) {
                heights.pop();                        
            }
            count++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
		StoneWall sw = new StoneWall();
		
		sw.solution(new int[]{1});
		sw.solution(new int[]{3,3});
		sw.solution(new int[]{5,10});
		sw.solution(new int[]{5,10,5,6,5});
		sw.solution(new int[]{5,10,4,11,7});
		sw.solution(new int[]{8,8,5,7,9,8,7,4,8});
	}
}

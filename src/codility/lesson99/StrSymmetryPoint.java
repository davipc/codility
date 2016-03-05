package codility.lesson99;


/**
 * 

Write a function:

class Solution { public int solution(String S); }

that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.

Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.

For example, given a string:

"racecar"

the function should return 3, because the substring to the left of the character "e" at index 3 is "rac", and the one to the right is "car".

Given a string:

"x"

the function should return 0, because both substrings are empty.

Assume that:

the length of S is within the range [0..2,000,000].
Complexity:

expected worst-case time complexity is O(length(S));
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).

 * 
 * @author Davi
 *
 */
public class StrSymmetryPoint {
	public int solution(String S) {
        int result = -1;
        
        // for such index to be possible the number of chars need to be odd
        if (S.length() % 2 == 1) {
            int middle = S.length() / 2;
            
            boolean valid = true;
            for (int i = 1; valid && i <= S.length()/2; i++) {
                valid = S.charAt(middle-i) == S.charAt(middle+i);
            }
            
            if (valid) 
                result = middle;
        }
        
        System.out.println(S + " => " + result + (result >= 0 ? " (" + S.charAt(result) + ")" : ""));
        
        return result;
    }
	
	
	public static void main(String[] args) {
		StrSymmetryPoint symm = new StrSymmetryPoint();
		
		symm.solution("");
		symm.solution("22");
		
		symm.solution("x");
		symm.solution("racecar");
		symm.solution("121");
		symm.solution("12121");
		symm.solution("1234567890987654321");
		
		symm.solution("123454323");
		
	}
}

package codility.lesson7;

import java.util.*;

/**
 * 
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 * 
 * @author Davi
 *
 */
public class Brackets {

	public int solution(String S) {
		int result = 1;

		Stack<Character> stack = new Stack<Character>();

		// iterate over the string
		char curr, popped;
		for (int i = 0; i < S.length(); i++) {
			curr = S.charAt(i);

			// if opening char, just add to stack
			if (curr == '(' || curr == '[' || curr == '{') {
				stack.push(curr);
			}
			// else handle each closing char separately
			else {
				if (stack.empty()) {
					result = 0;
					break;
				} else {
					popped = (Character) stack.pop();
					if (curr == ')' && popped != '(' || 
						curr == ']' && popped != '[' || 
						curr == '}' && popped != '{') {

						// issue found, return failure
						result = 0;
						break;
					}
				}
			}
		}

		// at the end, the stack should be empty
		if (!stack.empty()) {
			result = 0;
		}

		System.out.println(S + " => " + result);

		return result;
	}

	public static void main(String[] args) {
		Brackets b = new Brackets();
		
		b.solution("");
		b.solution("(");
		b.solution("{");
		b.solution("[");
		b.solution(")");
		b.solution("}");
		b.solution("]");
		b.solution("]{}");
		b.solution("({}");
		b.solution("[{}])");
		b.solution("()");
		b.solution("{}");
		b.solution("[]");
		b.solution("({[]})");
		b.solution("({}[]){(([]))}");
	}
}

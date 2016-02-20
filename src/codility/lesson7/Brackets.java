package codility.lesson7;

import java.util.*;

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
					if (curr == ')' && popped != '(' || curr == ']'
							&& popped != '[' || curr == '}' && popped != '{') {

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

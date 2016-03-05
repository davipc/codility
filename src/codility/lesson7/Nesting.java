package codility.lesson7;

/**
 * 
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).

 * 
 * @author Davi
 *
 */
public class Nesting {
	public int solution(String S) {
        int result = 1;
        
        int openParenthesis = 0;
        
        char c;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);

            if (c == '(')
                openParenthesis++;
            else 
                openParenthesis--;

            // if there were close parenthesis for no open one, fail        
            if (openParenthesis < 0) {
                result = 0;
                break;
            }
        }
        
        // if there were unclosed parenthesis, fail
        if (openParenthesis > 0)
            result = 0;
        
        System.out.println("\"" + S + "\" => " + result);
        return result;
    }
	
	
	public static void main(String[] args) {
		Nesting n = new Nesting();
		
		n.solution("");
		n.solution("(");
		n.solution(")");
		n.solution("())");
		n.solution("(()");
		n.solution("()()()()()");
		n.solution("((()))");
		n.solution("(()(()())((())()))");
	}
	
	
}

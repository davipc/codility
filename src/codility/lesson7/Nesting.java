package codility.lesson7;

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

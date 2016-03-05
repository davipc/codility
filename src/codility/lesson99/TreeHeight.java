package codility.lesson99;

public class TreeHeight {
	public int solution(Tree T) {
        int result = 0;
        
        result = calculateHeight(T);
        
        System.out.println(result);
        
        return result;
    }
    
    private int calculateHeight(Tree T) {
        if (T == null)
            return -1;

        return 1 + Math.max(calculateHeight(T.l), calculateHeight(T.r));
    }

    
    private static class Tree {
    	public int x;
    	public Tree l;
    	public Tree r;
    	
    	public Tree(int x, Tree l, Tree r) {
    		this.x = x; this.l = l; this.r = r;
    	}
    }
    
    
    public static void main(String[] args) {
		TreeHeight tree = new TreeHeight();
		
		tree.solution(null);
		tree.solution(new Tree(0, null, null));
		tree.solution(new Tree(1, new Tree(0, null, null), null));
		tree.solution(new Tree(1, new Tree(0, null, null), new Tree(0, null, null)));
		tree.solution(new Tree(2, new Tree(1, null, new Tree(0, null, null)), new Tree(1, null, null)));
	}
}

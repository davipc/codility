package codility;

import java.util.Set;
import java.util.TreeSet;

public class TestSet {
	public static void main(String[] args) {
		Set<Integer> s = new TreeSet<Integer>();
		
		s.add(1);
		s.add(1);
		
		for (Integer i: s) {
			System.out.println(i);
		}
	}
}

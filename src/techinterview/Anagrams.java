package techinterview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * 

"Anagram": An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase using all the original letters exactly once; for example, the letters from 'icon' can be rearranged into 'coin'. The word is NOT an anagram of itself.

Devise a function that takes one parameter W and returns all the anagrams of W from the file wl.txt.

anagrams("beat") should return ["beta", "bate"]

===========================

Test cases:

"able" => ["abel", "bale", "beal"]
"apple" => ["appel"]
"spot" => ["post", "pots", "stop", "tops"]
"reset" => ["steer", "trees"]

 * 
 * 
 * @author Davi
 *
 */
public class Anagrams {
	
	private static HashMap<String, Set<String>> map = new HashMap<>();
	
	private static void processWordsFromFile(String filename) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		String line = reader.readLine(); 
		while (line != null) {
			// process the word
			processWord(line.trim());
			line = reader.readLine();
		}
		
		reader.close();
	}
	
	
	private static void processWord(String word) {
		String orderedChars = orderCharsInString(word);
		
		Set<String> anagrams = map.get(orderedChars);
		if (anagrams == null) {
			anagrams = new TreeSet<String>();
		}
		if (!anagrams.contains(word)) {
			anagrams.add(word);
		}
		
		map.put(orderedChars, anagrams);
		
		//System.out.println(word);
	}


	public static Set<String> findAnagrams(String word) {
		Set<String> anagrams = new TreeSet<String>();
		
		String orderedChars = orderCharsInString(word);
		
		Set<String> found = map.get(orderedChars);
		
		if (found != null) {
			for (String str: found) {
				if (!word.equals(str)) {
					anagrams.add(str);
				}
			}
		}
		
		System.out.println(anagrams);
		return anagrams;
	}
	
	private static String orderCharsInString(String word) {
		char[] chars = word.toCharArray();
		
		Arrays.sort(chars);
		
		String result = new String(chars);
		return result;
	}


	public static void main(String[] args) throws Exception {
		processWordsFromFile("./txt/wl.txt");
		
		findAnagrams("able");
		findAnagrams("apple");
		findAnagrams("spot");
		findAnagrams("reset");	
		
	}
}

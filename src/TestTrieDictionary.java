import java.util.HashMap;

/*
 * We build a Trie of all dictionary words. Once the Trie is built, 
 * traverse through it using characters of input string. If prefix matches a dictionary word, store current length 
 * and look for a longer match. Finally, return the longest match.
 * Following is Java implementation of the above solution based.
 */

//Testing class
public class TestTrieDictionary {

	public static void main(String args[]) {
		Trie dict = new Trie();

		dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");
		dict.insert("basement");

		String input = "caterer";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
		System.out.println("find: " + dict.findPartial(input));

		input = "basement";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
		System.out.println("find: " + dict.findPartial(input));

		input = "are";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
		System.out.println("find: " + dict.findPartial(input));

		input = "arex";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
		System.out.println("find: " + dict.findPartial(input));

		input = "base";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
		System.out.println("find: " + dict.findPartial(input));

		input = "xyz";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
		System.out.println("find: " + dict.findPartial(input));

	}
}

// Implements the actual Trie
class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode((char) 0);
	}

	// insert new word into the Trie
	public void insert(String word) {
		int wordLength = word.length();

		TrieNode crawl = root;

		// traverse through all character of given word
		for (int level = 0; level < wordLength; level++) {
			HashMap<Character, TrieNode> child = crawl.getChildren();

			char ch = word.charAt(level);

			// If there is already a child for current character of given word

			if (child.containsKey(ch)) {
				crawl = child.get(ch);
			} else {
				// create the trie node and move forward
				TrieNode temp = new TrieNode(ch);
				child.put(ch, temp);
				crawl = temp;
			}
		}

		crawl.setIsCompleteWord(true);
	}

	// This main method that finds the longest string 'input'
	public String getMatchingPrefix(String input) {

		String result = ""; // Initialize resultant string

		int length = input.length();

		TrieNode crawl = root;

		// iterate through all character of input string 'str' and traverse down
		// the trie

		int level, prevMatch = 0;

		for (level = 0; level < length; level++) {
			char ch = input.charAt(level);

			HashMap<Character, TrieNode> child = crawl.getChildren();

			if (child.containsKey(ch)) {
				result += ch; // update result
				crawl = child.get(ch); // move to next node;

				if (crawl.isEnd())
					prevMatch = level + 1;

			} else
				break;
		}

		if (!crawl.isEnd())
			return result.toLowerCase().substring(0, prevMatch);
		else
			return result;
	}

	/*
	 * Find partial where partial is a string denoting a partial name to search
	 * the application for. It must count the number of contacts starting with
	 * partial and print the count on a new line.
	 */

	public int findPartial(String input) {

		int length = input.length();

		TrieNode crawl = root;

		// go through full traversal and find number of child present at the end
		// of the branch
		int noOfMatch = 0;
		int level;
		for (level = 0; level < length; level++) {

			char ch = input.charAt(level);

			HashMap<Character, TrieNode> temp = crawl.getChildren();

			// check the current node is last node or not
			if (temp.containsKey(ch)) {
				crawl = temp.get(ch); // assign new crawl
				if (crawl.isEnd()) {
					noOfMatch = 1;
				}
			} else
				break;
		}

		if (level == length) {
			return (noOfMatch += crawl.getChildren().size());
		} else
			return 0;
	}
}

class TrieNode {

	private char value;
	private HashMap<Character, TrieNode> children;
	private boolean isCompleteWord;

	public TrieNode(char ch) {
		value = ch;
		children = new HashMap<>();
		isCompleteWord = false;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public char getVlaue() {
		return value;
	}

	public void setIsCompleteWord(boolean val) {
		isCompleteWord = val;
	}

	public boolean isEnd() {
		return isCompleteWord;
	}
}
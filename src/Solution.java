import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;
	
	public Solution(String magazine, String note) {
		// TODO Auto-generated constructor stub
		
		magazineMap = new HashMap<>();
		noteMap = new HashMap<>();
		
		String[] wordsMagazine = magazine.split(" ");
		
		for(String word : wordsMagazine){
			
			if(magazineMap.containsKey(word))
				magazineMap.put(word, magazineMap.get(word) + 1);
			else
				magazineMap.put(word, 1);
		}
		
		String[] wordsNote = note.split(" ");
		
		for(String word : wordsNote){
			
			if(noteMap.containsKey(word))
				noteMap.put(word, noteMap.get(word) + 1);
			else
				noteMap.put(word, 1);
		}
	}

	private boolean solve() {
		// TODO Auto-generated method stub
		
		Set<String> noteSet = noteMap.keySet();
		Iterator<String> itr = noteSet.iterator();
		boolean decision = true;
		
		while(itr.hasNext() && decision){
			
			String test = itr.next();
			
			while(noteMap.get(test) != 0){
				
				if(noteMap.get(test) <= magazineMap.get(test)){
					magazineMap.put(test, magazineMap.get(test)-noteMap.get(test));
					noteMap.put(test, 0);
				}
				else{
					decision = false;
					break;
				}
			}
		}
		return decision;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner scanner = new Scanner(System.in);
	
	int m = scanner.nextInt();
	int n = scanner.nextInt();
	boolean ans = false;
	
	if(m>=n){
		scanner.nextLine();
		Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
		scanner.close();
		ans = s.solve();
	}
	
	if(ans)
		System.out.println("Yes");
	else System.out.println("No");
	}

}

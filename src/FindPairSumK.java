import java.util.HashSet;
import java.util.Set;

/*
 * finding number of pair from array whose sum is k
 */
public class FindPairSumK {

	public static void main(String args[]){
		int a[] = {1,3,46,1,3,9};
		
		int k = 47;
		int pair = 0;
		
		Set<Integer> mySet = new HashSet<Integer>();
		for(int i: a){
			mySet.add(i);
		}
		
		for(int i:a){
			if(mySet.contains(k-i)){
				mySet.remove(i);
				mySet.remove(k-i);
				pair = pair+1;
			}
		}
		System.out.println(pair);
	}
}

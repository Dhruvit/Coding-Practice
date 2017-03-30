import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class ListIntersection {
	public static void main(String[] args) {
		Collection listOne = new ArrayList(Arrays.asList("milan", "dingo",
				"elpha", "hafil", "meat", "iga", "neeta.peeta"));
		Collection listTwo = new ArrayList(Arrays.asList("hafil", "iga",
				"binga", "mike", "dingo"));

		listTwo.retainAll(listOne);
		System.out.println(listTwo);
		
		listOne.retainAll(listTwo);
		System.out.println(listOne);
	}
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 5
 amy 100
 david 100
 heraldo 50
 aakansha 75
 aleksa 150 
 */

public class ComparatorTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}

		scan.close();

		Checker chk = new Checker();
		
		Arrays.sort(player, chk);

		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].getName(),
					player[i].getScore());
		}
	}
}

class Player {

	private String name;
	private int score;

	public Player(String name, int score) {
		this.score = score;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

class Checker implements Comparator<Player> {

	@Override
	public int compare(Player a, Player b) {
		if (a.getScore() == b.getScore()) {
			return a.getName().compareTo(b.getName());
		}
		return b.getScore() - a.getScore();
	}
}
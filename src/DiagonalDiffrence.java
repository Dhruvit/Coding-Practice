import java.util.Scanner;

/*
 3
 11 2 4
 4 5 6
 10 8 -12
 */
public class DiagonalDiffrence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[][] = new int[n][n];
		int first_diagonal = 0;
		int second_diagonal = 0;

		for (int a_i = 0; a_i < n; a_i++) {
			for (int a_j = 0; a_j < n; a_j++) {
				a[a_i][a_j] = in.nextInt();

				if (a_i == a_j) {
					first_diagonal += a[a_i][a_j];
				}
				if ((a_i + a_j) == (n - 1)) {
					second_diagonal += a[a_i][a_j];
				}
			}
		}
		System.out.println(Math.abs(first_diagonal - second_diagonal));
		in.close();
	}
}

import java.util.*;

/*
 * Dynamic median
 */
public class DynamicMedian {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		float median;

		/* stored the upper highest part of the sorted data */
		PriorityQueue<Integer> lower = new PriorityQueue<Integer>(10000,
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						// sort in ascending order
						return o2 - o1;
					}
				});

		/* stored the lowest part of the sorted data */
		PriorityQueue<Integer> higher = new PriorityQueue<Integer>();

		for (int c : a) {
			if (lower.isEmpty()) {
				lower.add(c);
			} else {
				if (lower.size() > higher.size()) {
					// lower is bigger
					if (lower.peek() > c) {
						// balance - take highest from lower, put it in higher
						higher.add(lower.poll());
						lower.add(c);
					} else {
						higher.add(c);
					}
				} else {
					// higher is bigger
					Integer p = higher.peek();
					if (p != null && p >= c) {
						lower.add(c);
					} else {
						lower.offer(higher.poll());
						higher.add(c);
					}
				}
			}

			int s = lower.size() + higher.size();

			if (s % 2 == 0) {
				median = (lower.peek() + higher.peek()) / 2.0f;
			} else {
				median = (float) lower.peek();
			}
			System.out.println(median);
		}

		in.close();

	}
}
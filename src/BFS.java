import java.util.Iterator;
import java.util.LinkedList;

/* 
 * BFS and DFS traversal
 */

public class BFS {

	private int V; // # of vertices
	private LinkedList<Integer> adj[]; // adjacency list

	// constructor
	@SuppressWarnings("unchecked")
	public BFS(int v) {

		V = v;
		adj = new LinkedList[v];

		// make new linked list for each vertices
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	// function to add an edge from source to destination
	private void addEdge(int s, int d) {
		adj[s].add(d);
	}

	// prints BFS traversal from a given source s
	private void BFStraversel(int s) {

		// marked all vertices as not visited(By default set as false)
		boolean visited[] = new boolean[V];

		// create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {

			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();

			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	private void DFSTraversal(int s) {
		boolean[] visited = new boolean[V];

		DFSUtill(s, visited);
	}

	private void DFSUtill(int v, boolean[] visited) {

		visited[v] = true;
		System.out.print(v + " ");

		Iterator<Integer> i = adj[v].listIterator();

		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtill(n, visited);
		}

	}

	public static void main(String[] args) {
		BFS g = new BFS(4);

		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.BFStraversel(2);
		System.out.println(" ");
		g.DFSTraversal(2);
	}

}

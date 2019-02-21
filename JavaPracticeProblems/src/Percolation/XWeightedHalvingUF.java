package Percolation;
import java.util.Arrays;
import stdlib.*;
/* **************************************************************************
 *  Compilation:  javac WeightedQuickUnionHalvingUF.java
 *  Execution:  java WeightedQuickUnionHalvingUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Weighted quick-union with path compression via halving.
 *
 ****************************************************************************/

public class XWeightedHalvingUF implements UF {
	private int[] id;    // id[i] = parent of i
	private int[] sz;    // sz[i] = number of objects in subtree rooted at i
	private int count;   // number of components

	// instantiate N isolated components 0 through N-1
	public XWeightedHalvingUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	// return number of connected components
	public int count() {
		return count;
	}

	// return component identifier for component containing p
	public int find(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]];    // path compression by halving
			p = id[p];
		}
		return p;
	}

	// are elements p and q in the same component?
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	// merge components containing p and q, making smaller root point to larger one
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		if (pid == qid) return;
		// in the case of a tie, p is the champion
		if   (sz[pid] < sz[qid]) { id[pid] = qid; sz[qid] += sz[pid]; }
		else                     { id[qid] = pid; sz[pid] += sz[qid]; }
		count--;
	}

	public String toString() { return Arrays.toString (id); }

	public static void main(String[] args) {
		StdIn.fromFile ("data/tinyUF.txt");
		//StdIn.fromFile ("data/mediumUF.txt");
		//StdIn.fromFile ("data/largeUF.txt");

		int N = StdIn.readInt();
		XWeightedHalvingUF uf = new XWeightedHalvingUF(N);

		// read in a sequence of pairs of integers (each in the range 0 to N-1),
		// calling find() for each pair: If the members of the pair are not already
		// call union() and print the pair.
		Stopwatch sw = new Stopwatch ();
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
			GraphvizBuilder.ufToFile (uf.id);
		}
		StdOut.format("XWeightedQuickUnionHalvingUF # components: %d [%f]", uf.count(), sw.elapsedTime ());
	}

}

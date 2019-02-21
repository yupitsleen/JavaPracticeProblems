package Percolation;

//use interactive perc vis to test
// Uncomment the import statements above.

// You can test this using InteractivePercolationVisualizer and PercolationVisualizer
// All methods should make at most a constant number of calls to the UF data structure,
// except percolates(), which may make up to N calls to the UF data structure.
public class Percolation {
	int N;
	boolean[] open;
	int topSlot; // id=0
	int bottomSlot; // id=N*N+1
	WeightedUF Wu;

	public Percolation(int N) {
		this.N = N;
		this.open = new boolean[N * N];
		this.topSlot = 0;
		this.bottomSlot = N * N + 1;
		this.open = new boolean[(N * N) + 2]; // create N-by-N grid, with all sites blocked
		// connect top slot to open slots in top row
		this.Wu = new WeightedUF(N * N + 2);
		WeightedUF two = new WeightedUF(N * N + 2);
		for (int i = 1; i <= N; i++) {
			this.Wu.union(i, this.topSlot);
		}
		// connect bottom row open slots to bottom slot // key to use diff weightedUF to avoid backwash
		for (int i = (N * N) - N; i <= N * N; i++) {
			two.union(i, this.bottomSlot);
		}
	}

	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		this.open[i * this.N + j] = true;
		int current = i * this.N + j + 1;
		// union with all the open neighbors
		// ex. Union(#(i,j),#(i+1,j)) if (i+1,j) is open
		if (i + 1 < this.N && isOpen(i + 1, j))
			this.Wu.union(current, current + this.N);
		if (i - 1 >= 0 && isOpen(i - 1, j))
			this.Wu.union(current, current - this.N);
		if (j + 1 < this.N && isOpen(i, j + 1))
			this.Wu.union(current, current + 1);
		if (j - 1 >= 0 && isOpen(i, j - 1))
			this.Wu.union(current, current - 1);
	}

	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) {
		return this.open[i * this.N + j];
	}

	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		int current = i * this.N + j + 1;
		if (this.Wu.connected(current, this.bottomSlot) && this.Wu.connected(current, this.topSlot))
			this.Wu.union(this.topSlot, this.bottomSlot);
		return (isOpen(i, j) && this.Wu.connected(current, this.topSlot));
	}

	// does the system percolate?
	public boolean percolates() {
		return this.Wu.connected(this.topSlot, this.bottomSlot);

	}
}

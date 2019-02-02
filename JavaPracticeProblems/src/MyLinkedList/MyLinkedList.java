package MyLinkedList;

import stdlib.*;

public class MyLinkedList {
	static class Node {
		public Node() {
		}

		public double item;
		public Node next;
	}

	int N;
	Node first;

	public MyLinkedList() {
		first = null;
		N = 0;
		checkInvariants();
	}

	private void myassert(String s, boolean b) {
		if (!b)
			throw new Error("Assertion failed: " + s);
	}

	private void checkInvariants() {
		myassert("Empty <==> first==null", (N == 0) == (first == null));
		Node x = first;
		for (int i = 0; i < N; i++) {
			if (x == null) {
				throw new Error("List too short!");
			}
			x = x.next;
		}
		myassert("EndOfList == null", x == null);
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void add(double item) {
		Node newfirst = new Node();
		newfirst.item = item;
		newfirst.next = first;
		first = newfirst;
		N++;
	}

	// return Double.NEGATIVE_INFINITY if the linked list is empty
	// DONE
	public double max() {
		return max(first);
	}

	private static double max(Node x) {
		if (x == null)
			return Double.NEGATIVE_INFINITY;
		double Max = x.item;

		while (x != null) {
			if (x.item > Max) {
				Max = x.item;
			}
			x = x.next;

		}
		return Max;

	}

//DONE
	public double maxRecursive() {
		return maxRecursive(first, Double.NEGATIVE_INFINITY);
	}

	private static double maxRecursive(Node x, double result) {
		if (x == null)
			return result;

		if (result < x.item)
			result = x.item;
		x = x.next;
		return maxRecursive(x, result);

	}

	// delete the kth element
	public void delete(int k) {
		if (k < 0 || k >= N)
			throw new IllegalArgumentException();

		// [1];
		if (N == 1) {
			first = null;
			N--;
			return;
		}

		if (k == 0) {
			// [1,2,3,4,5,6,7,8,9,10,11,12]
			// delete first
			first = first.next;
			N--;
		} else {
			// [2,3,4,5,6,7,8,9,10,11]
			// delete 4
			int count = 0;
			for (Node x = first; x != null; x = x.next) {
				//ONLY FOR LAST ITEM remove the last item and we are at the last item
				if (k == N-1 && x.next.next == null) {
					x.next = null;
					N--;
					break;
				}
				//in middle of list
				if (count == k - 1) {
					x.next = x.next.next;
					N--;
				}
				count++;
			}
		}

		checkInvariants();
	}

	// reverse the list "in place"... without creating any new nodes
	public void reverse() {

		Node prev = null;
		Node next = null;
		Node curr = first;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}
		first = prev;

		checkInvariants();
	}

	// remove
	public void remove(double item) {
		// empty
		if (N == 0) {
			return;
		}
		// singleton but not the item
		else if (N == 1 & first.item != item) {
			return;
		}
		// singleton and is the item
		else if (N == 1 & first.item == item) {
			first = null;
			N--;
			return;
		}
		
		for (Node x = first; x != null; x = x.next) {
			if (x.next == null)
				return;

			else if (x.next.item == item) {
				x.next = x.next.next;
				N--;
				return;
			}
		}

		checkInvariants();
		return;
	}

	private static void print(String s, MyLinkedList b) {
		StdOut.print(s + ": ");
		for (Node x = b.first; x != null; x = x.next)
			StdOut.print(x.item + " ");
		StdOut.println();
	}

	private static void print(String s, MyLinkedList b, double i) {
		StdOut.print(s + ": ");
		for (Node x = b.first; x != null; x = x.next)
			StdOut.print(x.item + " ");
		StdOut.println(": " + i);
	}

	private static void testMax() {
		MyLinkedList b = new MyLinkedList();
		print("empty", b, b.max());
		b.add(-1);
		print("singleton", b, b.max());
		b.add(-2);
		b.add(-3);
		b.add(-4);
		print("at end", b, b.max());
		b.add(5);
		print("at beginning", b, b.max());
		b.add(3);
		b.add(2);
		b.add(4);
		print("in the middle", b, b.max());
	}

	private static void testMaxRecursive() {
		MyLinkedList b = new MyLinkedList();
		print("empty", b, b.maxRecursive());
		b.add(-1);
		print("singleton", b, b.maxRecursive());
		b.add(-2);
		b.add(-3);
		b.add(-4);
		print("at end", b, b.maxRecursive());
		b.add(5);
		print("at beginning", b, b.maxRecursive());
		b.add(3);
		b.add(2);
		b.add(4);
		print("in the middle", b, b.maxRecursive());
	}

	private static void testDelete() {
		MyLinkedList b = new MyLinkedList();
		b.add(1);
		print("singleton", b);
		b.delete(0);
		print("deleted", b);
		for (double i = 1; i < 13; i++) {
			b.add(i);
		}
		print("bigger list", b);
		b.delete(0);
		print("deleted at beginning", b);
		b.delete(10);
		print("deleted at end", b);
		b.delete(4);
		print("deleted in middle", b);
	}

	private static void testReverse() {
		MyLinkedList b = new MyLinkedList();
		b.reverse();
		print("reverse empty", b);
		b.add(1);
		print("singleton", b);
		b.reverse();
		print("reverse singleton", b);
		b.add(2);
		print("two", b);
		b.reverse();
		print("reverse two", b);
		b.reverse();
		print("reverse again", b);
		for (double i = 3; i < 7; i++) {
			b.add(i);
			b.add(i);
		}
		print("bigger list", b);
		b.reverse();
		print("reversed", b);
	}

	private static void testRemove() {
		MyLinkedList b = new MyLinkedList();
		b.remove(4);
		print("removed 4 from empty", b);
		b.add(1);
		b.remove(4);
		print("removed 4 from singelton", b);
		b.remove(1);
		print("removed 1 from singelton", b);
		for (double i = 1; i < 5; i++) {
			b.add(i);
			b.add(i);
		}
		for (double i = 1; i < 5; i++) {
			b.add(i);
			b.add(i);
			b.add(i);
			b.add(i);
			b.add(i);
		}
		print("longer list", b);
		b.remove(9);
		print("removed all 9s", b); // does nothing
		b.remove(3);
		print("removed all 3s", b);
		b.remove(1);
		print("removed all 1s", b);
		b.remove(4);
		print("removed all 4s", b);
		b.remove(2);
		print("removed all 2s", b); // should be empty
	}

	public static void main(String args[]) {
		 testMax (); //DONE
		 testMaxRecursive (); //DONE
		 testDelete (); //DONE
		 testReverse();
		testRemove();
	}
}

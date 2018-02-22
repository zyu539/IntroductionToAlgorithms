public class UnionFind {
	
	public static Node<Integer> makeSet(int x) {
		Node<Integer> n = new Node<>(x);
		n.p = n;
		n.rank = 0;
		return n;
	}
	
	public static void union(Node<Integer> x, Node<Integer> y) {
		link(findSet(x), findSet(y));
	}
	
	private static void link(Node<Integer> x, Node<Integer> y) {
		if (x.rank < y.rank) {
			x.p = y;
		} else {
			y.p = x;
			if (x.rank == y.rank) {
				x.rank++;
			}
		}
	}
	
	public static Node<Integer> findSet(Node<Integer> n) {
		if (n != n.p) {
			n.p = findSet(n.p);
		}
		return n.p;
	}
	
}

class Node<V> {
	V val;
	int rank;
	Node<V> p;
	
	Node(V val) {
		this.val = val;
	}
}

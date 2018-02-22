import java.util.List;

//Chapter 22.5 Strong Component
class KosarajuStrongComponent {
	boolean[] vis;
	int[] order; //vertex order after first dfs
	int color;
	int[] belong;
	int n; //number of vertex;
	List<Integer>[] G;
	List<Integer>[] GT;
	int no;
	public void kosaraju(List<Integer>[] G, List<Integer>[] GT) {
		this.G = G;
		this.GT = GT;
		order = new int[G.length];
		vis = new boolean[G.length];
		belong = new int[G.length];
		n = G.length;
		color = 0;
		//first dfs
		for (int i = 0; i < n; i++) {
			if(!vis[i]) dfs1(i);
		}
		//second dfs
		vis = new boolean[G.length]; // reset vis matrix for inverse graph.
		for (int i = n-1; i >= n; i--) {
			int v = order[i];
			if (!vis[v]) {
				dfs2(i);
				color++;
			}
		}
		//make strong components to single node
		boolean[][] dag = new boolean[color][color];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < G[i].size(); j++) {
				if (belong[i] == belong[G[i].get(j)]) continue;
				dag[belong[i]][belong[G[i].get(j)]] = true;
			}
		}
	}
	
	private void dfs1(int u) {
		vis[u] = true;
		for (int i = 0; i < G[u].size(); i++) {
			int v = G[u].get(i);
			if (!vis[v]) {
				dfs1(v);
			}
		}
		order[no++] = u; //give an index to each vertex according to finish time.
	}
	
	private void dfs2(int u) {
		vis[u] = true;
		belong[u] = color;
		for (int i = 0; i< GT[u].size(); i++) {
			int v = GT[u].get(i);
			if (!vis[v]) {
				dfs2(v);
			}
		}
	}
}

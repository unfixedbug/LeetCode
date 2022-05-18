class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
	// use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
	List<Integer>[] graph = new ArrayList[n];
	List<List<Integer>> res = new ArrayList<>();
	Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
	for (int i = 0; i < n; i++) {
		graph[i] = new ArrayList<>();
	}
	// build graph
	for (int i = 0; i < connections.size(); i++) {
		int from = connections.get(i).get(0), to = connections.get(i).get(1);
		graph[from].add(to);
		graph[to].add(from);
	}

	for (int i = 0; i < n; i++) {
		if (disc[i] == -1) {
			dfs(i, low, disc, graph, res, i);
		}
	}
	return res;
}

int time = 0; // time when discover each vertex

private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
	disc[u] = low[u] = ++time; // discover u
	for (int j = 0; j < graph[u].size(); j++) {
		int v = graph[u].get(j);
		if (v == pre) {
			continue; // if parent vertex, ignore
		}
		if (disc[v] == -1) { // if not discovered
			dfs(v, low, disc, graph, res, u);
			low[u] = Math.min(low[u], low[v]);
			if (low[v] > disc[u]) {
				// u - v is critical, there is no path for v to reach back to u or previous vertices of u
				res.add(Arrays.asList(u, v));
			}
		} else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
			low[u] = Math.min(low[u], disc[v]);
		}
	}
    }
}
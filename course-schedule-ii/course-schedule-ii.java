class Solution {
  class Graph {
        int length;
        List<Integer>[] adj;
        
        boolean[] onStack;
        boolean[] marked;
        int position;
        int[] topo;
        boolean hasCycle;

        public Graph(int n) {
            length = n;
            adj = new ArrayList[n];
            
            onStack = new boolean[length];
            marked = new boolean[length];
            topo = new int[length];
            position = 0;
            hasCycle = false;
        }

        public void addEdge(int from, int to) {
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }

            adj[from].add(to);
        }

        public int[] top() {
            for (int i = 0; i < length; i++) {
                if (!marked[i]) {
                    dfs(i);
                }
            }
            
            if (hasCycle) {
                return new int[0];
            }
            return topo; 
        }
        
        public void dfs(int i) {
            if (hasCycle) {
                return;
            }
            
            marked[i] = true;
            onStack[i] = true;
            
            if (adj[i] != null) {
                for (int j : adj[i]) {
                    if (!marked[j]) {
                        dfs(j);
                    } else if (onStack[j]) {
                        hasCycle = true;
                    }
                }
            }
            
            onStack[i] = false;
            topo[position] = i;
            position = position + 1;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Graph g = new Graph(numCourses);
        
        for(int[] pre: prerequisites){
            g.addEdge(pre[0],pre[1]);
        }
        return g.top();
      
  }
  
}
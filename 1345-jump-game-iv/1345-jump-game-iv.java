class Solution {
   
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        Map<Integer ,List<Integer>> graph  = new HashMap<>(); // value, same valued indexes
        for(int i=0;i<n;i++){
            if(!graph.containsKey(arr[i])){
                graph.put(arr[i], new ArrayList<>());
            }
            graph.get(arr[i]).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        boolean[]visited = new boolean[n];
        q.add(0);
        visited[0]=true;
        
        int steps=0;
        while(!q.isEmpty()){
            for(int k=0, size = q.size(); k< size;k++){//iterating thorugh all indices with same value
                int i=q.remove(); // remove, or poll the remove
                if(i== n-1) return steps;
                if(i-1 >=0 && !visited[i-1]){
                    q.add(i-1);
                    visited[i-1]=true;
                }
                if(i+1 < n && !visited[i+1]){
                    q.add(i+1);
                    visited[i+1]=true;
                }
                if(graph.containsKey(arr[i])){
                    for(int j: graph.get(arr[i])){
                        if(!visited[j]){
                            q.add(j);
                            visited[j]=true;
                        }
                    }
                    graph.remove(arr[i]);
                }
            }
            steps++;
        }
        return -1;
    }
}
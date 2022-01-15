class Solution {
    
    public int minJumps(int[] arr) {
        int N = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for( int i = 0; i < N; i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[N];
        visited[0] = true;
        
        int steps = 0;
        while(!q.isEmpty()){
            for( int k = 0, size = q.size(); k < size; k++){
                int i = q.remove();
                if( i == N-1)
                    return steps;
                if( i-1 >= 0 && !visited[i-1]){
                    q.add(i-1);
                    visited[i-1] = true;
                }
                if( i+1 < N && !visited[i+1]){
                    q.add(i+1);
                    visited[i+1] = true;
                }
                if( map.containsKey(arr[i])){
                    for( int j : map.get(arr[i])){
                        if( !visited[j]){
                            q.add(j);
                            visited[j] = true;
                        }  
                    } 
                    map.remove(arr[i]);
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    
    public int minJumps2nd(int[] arr) {
        
        int n = arr.length;
        if(n<=1) return 0;
        
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
class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        if(n<=1) return 0;
        
        Map<Integer ,List<Integer>> graph  = new HashMap<>(); // value, same valued indexes
        for(int i=0; i<n ; i++){
            graph.computeIfAbsent(arr[i], v-> new LinkedList<>()).add(i);
            
//                                 value, (indexes with value (value))
        }
            List<Integer>curs = new LinkedList<>(); //store current layer
            curs.add(0);
            Set<Integer> visited = new HashSet<>();
            int step=0;
            
            while(!curs.isEmpty()){
                List<Integer> nex = new LinkedList<>();
                
                for(int node: curs){
//                     check if reched thee end
                    if(node ==n-1) return step;
                    
                    //check whether same value exist?
                    for(int child: graph.get(arr[node])){ // iterating thorught values of graph
                        if(!visited.contains(child)){
                            visited.add(child);
                            nex.add(child); //next layer
                        }
                    }

                    // clear the list, ie all values of the node, to prevent redundant searches
                   graph.get(arr[node]).clear();
                    
                    // check neighbours
                    if(!visited.contains(node+1)  && node +1 < n){
                        visited.add(node+1);
                        nex.add(node+1);
                    }
                    if(!visited.contains(node-1) && node -1 >=0){
                        visited.add(node-1);
                        nex.add(node -1);
                    }
                }
                curs  =nex;
                step++;
            }
            
        return -1;
    }
}
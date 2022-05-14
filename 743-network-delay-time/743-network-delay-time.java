class Solution {
    
    Map<Integer, List<Pair<Integer,Integer>>> graph = new HashMap<>();
    
    public void dijkstra(int[] Time, int source, int k){
        Queue<Pair<Integer,Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>(Comparator.comparing(Pair::getKey)); // stores node and its visited time
        
        pq.add(new Pair(0,source)); //kuch to dala h
        
//         time for starting node is 0
        Time[source]=0;
        
        while(!pq.isEmpty()){
            Pair<Integer, Integer> topPair = pq.remove();
            
            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();
            
            if(currNodeTime > Time[currNode]){
                continue;// stored time is already smaller
            }
            if(!graph.containsKey(currNode)){// if map already contains, ie visited
                continue;
            }
            
            // bfs, boradcast to adjacent nodes
            for(Pair<Integer,Integer>edge: graph.get(currNode)){
                int time = edge.getKey();
                int neighborNode = edge.getValue();
                
                // fastest signal time for neighborNode so far
                // signalReceived[currNode] + time : time whe signal reaches neigborNode
                
                if(Time[neighborNode] > currNodeTime+time){
                    Time[neighborNode] = currNodeTime+time;
                    pq.add(new Pair(Time[neighborNode],neighborNode));
                }
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
//         create adjacency list
        for(int[] time:times){
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            graph.putIfAbsent(source, new ArrayList<>());
            graph.get(source).add(new Pair(travelTime, dest));
        }
        
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        
        dijkstra(signalReceivedAt, k, n);
        
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }
        
        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
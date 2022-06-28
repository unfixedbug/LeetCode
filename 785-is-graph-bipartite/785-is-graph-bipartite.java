class Solution {
    int [] colors;
    public boolean isBipartite(int[][] graph) {
         colors = new int[graph.length];
        Arrays.fill(colors,0);
        
        
        for(int i=0;i<graph.length;i++){
            if(colors[i]==0 && !validate(graph,1,i))return false;
        }
        return true;
    }
    
    private boolean validate(int[][] graph, int color, int node){
        if(colors[node]!=0)return colors[node]==color;// does the already given color, matches the expected color
        
        colors[node]=color;// give it hte expected color
        // traverse for the 
        for(int child:graph[node]){
            // children of 1 should be -1 only, so is for, ie, change the signs of 
            if(!validate(graph,-color,child))return false;
        }
        return true;
    }
}
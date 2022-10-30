class Solution {
    public int shortestPath(int[][] grid, int k) {
        this.n = grid.length;
        this.m = grid[0].length;
        int[] rows  = {0,1,0,-1};
        int[] cols  = {1,0,-1,0};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,0});
        boolean[][][] visited = new boolean[n][m][k+1];
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            int ct = q.size();
            for(int i=0;i<ct;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int dist = curr[2];
                if(r == n-1 && c==m-1){
                    return dist;
                }
                
                int obs = curr[3];
                
                for(int j=0;j<4;j++){
                    int newR = rows[j]+r;
                    int newC = cols[j]+c;
                    
                    if(isValid(newR, newC)){
                        int newObs = obs + (grid[newR][newC]==1?1:0);
                        if(newObs>k || visited[newR][newC][newObs] == true){
                            continue;
                        }
                        visited[newR][newC][newObs] = true;
                        q.add(new int[]{newR, newC, dist+1,newObs});
                    }
                }
            }
        }
        return -1;
    
    }
    int n = -1;
    int m = -1;
    private boolean isValid(int r, int c){
        return (r>=0 && r<n && c>=0 && c<m);    
    }
}
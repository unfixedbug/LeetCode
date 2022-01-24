class Solution {
    int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean visited[][];
    public int numIslands(char[][] grid) {
        int r =  grid.length;
        int c = grid[0].length;
        visited = new boolean[r][c];
        Queue<int[]>  queue = new LinkedList<>(); 
        int count = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    queue.offer(new int[]{i,j});
                    bfs(grid,queue);
                    visited[i][j]=true;
                    count++;
                }
            }   
        }
        return count;
    }
    public void bfs(char[][] grid,Queue<int []> queue ){
//         out of bound check
        while(!queue.isEmpty()){
            int []curr = queue.poll();
            for(int[] dir:dirs){
                int x = curr[0]+dir[0];
                int y = curr[1]+dir[1];
                if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || visited[x][y] || grid[x][y]=='0') continue;
                
                queue.offer(new int[]{x,y});
                visited[x][y]=true;
                        
        
            }
        }
    }
}
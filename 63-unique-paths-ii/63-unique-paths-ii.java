class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int r =  grid.length;
        int c = grid[0].length;
        if(grid[0][0]==1)return 0; // starting has obstacle
        
        grid[0][0]=1;
        
        for(int i=1; i<r;i++){
            grid[i][0] = (grid[i][0]==0 && grid[i-1][0]==1)?1:0;
        }
        for(int i=1; i<c;i++){
            grid[0][i] = (grid[0][i]==0 && grid[0][i-1]==1)?1:0;
        }
    
        for(int i=1;i <r;i++){
            for(int j=1;j<c;j++){
                if(grid[i][j]==0){//valid path
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
                else{
                    grid[i][j] =0;
                }
            }
        }
        return grid[r-1][c-1];
    }
}
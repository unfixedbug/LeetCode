class Solution {
    public int[] findBall(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        // no of balls == no of columns
        int a[] =  new int[m];
        for(int i=0;i<m;i++){
            a[i]=dfs(grid,0,i,m,n);
        }
        return a;
    }
    
    private int dfs(int[][]grid, int i, int j, int m, int n){
        //out of bound return -1
        if(j<0 ||j>=m)return -1;
        //if we are at the last row
        if(i>=n)return j;// return the column number
        
        if(grid[i][j]==1){
            // ball will go right down
            // check v condition
            if(j<m-1 &&grid[i][j+1]==-1)return -1;
            return dfs(grid,i+1,j+1,m,n);
        }
        else{
            if(j>0 && grid[i][j-1]==1)return -1;
            return dfs(grid,i+1,j-1,m,n);
        }
    }
}
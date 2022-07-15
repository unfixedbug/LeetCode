class Solution {
    boolean [][]vis;
    int [][]grid;
    int ans;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        ans=0;
        vis =new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j])ans = Math.max(ans,dfs(i,j));
            }
        }
        return ans;
    }
    
    private boolean isfeasible(int i,int j){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]==1 && !vis[i][j])return true;
        return false;
    }
    
    private int dfs(int i,int j){
        if(isfeasible(i,j)){
            vis[i][j]=true;
            return 1 + dfs(i+1,j)+dfs(i-1,j)+dfs(i,j+1)+dfs(i,j-1);
        }
        return 0;
    }
}
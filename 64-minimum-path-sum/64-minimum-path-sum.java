class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0)dp[i][j]=grid[i][j];
                if(dp[i][j]!=-1)continue;
                else if(i==0 && j!=0)dp[i][j] = grid[i][j]+dp[i][j-1];
                else if(i!=0 && j==0)dp[i][j] = grid[i][j]+dp[i-1][j];
                else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n-1][m-1];
    }
    
    
}
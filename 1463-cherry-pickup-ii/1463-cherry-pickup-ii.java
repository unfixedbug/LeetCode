class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
//         same row, diffrent columns foir robots, see (SOLN)
        
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return topdown(0, 0, m - 1, grid, dp);
    }
    private int topdown(int row, int col1, int col2, int[][]grid, int[][][]dp){
//         skip out of bound 
        if(col1 <0 || col1 >= grid[0].length || col2 <0 || col2 >= grid[0].length){
            return 0;
        }
        
//         return already available values from the dp
        if(dp[row][col1][col2] != -1){
            return dp[row][col1][col2];
        }
        
//         for the current cell
        int result = 0;
        result += grid[row][col1];
        if(col1 != col2) result+= grid[row][col2];
        
//         base case, boottom row
        if(row != grid.length-1){
            int max=0;
//             iterating from col -1, col, col+1
            for(int newcol1 = col1-1;newcol1 <= col1+1; newcol1++){
//                 newcol1 fpro robot1, and newcol2 for robot 2
                // col1, col2 are current columns of robot1, robot2
                for(int newcol2 = col2-1;newcol2 <= col2+1; newcol2++){
                    max = Math.max(max , topdown(row+1, newcol1, newcol2, grid, dp));
                }
            }
            result+=max;
        }
//         if not then
            dp[row][col1][col2] = result;
        return result;
    }
}
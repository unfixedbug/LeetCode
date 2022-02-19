class Solution {
    public int maximalSquare(char[][] matrix) {
     int height = matrix.length, width = matrix[0].length;
        int[][] dp = new int[height + 1][width + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;   
    }
}
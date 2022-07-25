class Solution {
    int dp[][];
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        dp = new int[n][n];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        // fill the last dp with values
        for(int i=0;i<n;i++){
            dp[n-1][i]=tri.get(n-1).get(i);
        }
        // tabulation is always opposite of memoisation so
        // observe carefully, it is an lower triangular matrix
        
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int ans = tri.get(i).get(j);
                int down = dp[i+1][j]; /// this wiill reach max n-1,n-1, that is precomputed
                int diagonal = dp[i+1][j+1];
                dp[i][j] = ans + Math.min(down,diagonal);
            }
        }
        return dp[0][0];
        
    }
    
   
}
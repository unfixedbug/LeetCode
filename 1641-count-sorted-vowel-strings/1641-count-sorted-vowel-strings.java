class Solution {
    public int countVowelStrings(int n) {
     int dp[][] = new int[n][5];//a e i o u;
//         fill first array
        int cnt=1;
        for(int i=4;i>=0;i--){
            dp[0][i] = cnt++;
        }
        
    for(int i=1;i<n;i++){
        for(int j=4;j>=0;j--){
            dp[i][j] = dp[i-1][j]+dp[i][j>=4?1:j+1];
        }
    }
        return dp[n-1][0];
    }
}
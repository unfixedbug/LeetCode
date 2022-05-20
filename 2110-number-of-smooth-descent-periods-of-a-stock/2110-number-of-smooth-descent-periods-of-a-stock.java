class Solution {
    public long getDescentPeriods(int[] prices) {
        int n  = prices.length;
        int dp[] = new int[n+1];
        // long dp=1;
        long ans=1;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            if(prices[i] == prices[i - 1] - 1) { //smooth meaning 1 1 se kam hoega
                dp[i] = dp[i-1]+1;
            } else {
                dp[i] = 1;
            }
            ans += dp[i];
        } // another one
        
        return ans;
    }
}
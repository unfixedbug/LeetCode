class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n+1];
        long mod = 1000000007;
        long share = 0,ans=0;
        dp[1]=1;
        //dp[0]=0;
        for(int i=2;i<=n;i++){
            dp[i] = share=(share+ dp[Math.max(0,i-delay)] - dp[Math.max(0,i-forget)]+mod)%mod;
        }
        for(int i=n-forget+1;i<=n;i++){
             // forget window
            ans  = (ans+dp[i])%mod;
        }
        return (int)ans;
    }
}
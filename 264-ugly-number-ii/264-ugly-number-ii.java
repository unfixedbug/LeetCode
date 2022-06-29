class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)return 1;
        int dp[] = new int[n+1];
        dp[1]=1;
        int m2=1,m3=1,m5=1;// start from the first element
        for(int i=2;i<=n;i++){
            // minimum multiple of previous ugly number,multplied by 2,3,5, not repeated
            dp[i] = Math.min(2*dp[m2],Math.min(3*dp[m3], 5*dp[m5]));
            
            // see who donated the minimum element and accordingly incrrease the pointer
            if(dp[i]==2*dp[m2])m2++;
            if(dp[i]==3*dp[m3])m3++;
            if(dp[i]==5*dp[m5])m5++;
        }
        return dp[n];
    }
}
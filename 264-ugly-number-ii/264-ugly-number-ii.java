class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)return 1;
        int []dp = new int[n];
        dp[0]=1;
        int l2=0,l3=0,l5=0;
        for(int i=1;i<n;i++){
            dp[i] = Math.min(2*dp[l2],Math.min(3*dp[l3],5*dp[l5]));
            if(dp[i]==2*dp[l2]){
                l2++;
            }
            if(dp[i]==3*dp[l3]) l3++;
            if(dp[i]==5*dp[l5])l5++;
        }
        return dp[n-1];
    }
}
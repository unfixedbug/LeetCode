class Solution {
    
    
    public int numRollsToTarget(int n, int k, int target) {
        int dp[] = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int dp1[] = new int[target+1];
            for(int j=1;j<=k;j++){
                for(int o=j;o<=target;o++){
                    dp1[o] = (dp1[o]+dp[o-j])%1000000007;                    
                }
            }
            int temp[] = dp1;
            dp1=dp;
            dp=temp;
        }
        return dp[target];
    }
    
    private void swap(int a[],int b[]){
        int temp[] = a;
        a=b;
        b=temp;
    }
}
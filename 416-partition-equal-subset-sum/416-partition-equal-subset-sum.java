class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int e:nums)sum+=e;
        if(sum%2==1)return false;
        
        return subsetSum(nums,sum/2);
        
    }
    private boolean subsetSum(int[]nums,int sum){
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)dp[i][0]=true;
        for(int i=1;i<=sum;i++)dp[0][i]=false;
        
        // dp[i][j] gives sum j possible with i ?
        // do for ith item
        for(int i=1;i<=n;i++){
            // do for sum i
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][sum];
    }
}
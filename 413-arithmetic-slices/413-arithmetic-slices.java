class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
     int n = nums.length;
        if(n<=2)return 0;
        int dp[] = new int[n];
        dp[0]=0;
        dp[1]=0;int ans=0;
        for(int j=2;j<n;j++){
            if(nums[j]-nums[j-1] == nums[j-1] - nums[j-2]){  dp[j] = dp[j-1] + 1;
                                                           ans+=dp[j];
                                                          }
        }
        return ans;
    }
}


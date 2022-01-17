class Solution {
    public int lengthOfLIS(int[] nums) {
//         n^2 dp
        int n=nums.length;
        int ans=0;
        int max = Integer.MIN_VALUE;
        int dp[] = new int [n];
        for(int i=0;i<n;i++){
            dp[i]=1;}
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        for (int i = 0; i < n; i++)
            if (max < dp[i])
                max = dp[i];
 
        return max;
    }
}
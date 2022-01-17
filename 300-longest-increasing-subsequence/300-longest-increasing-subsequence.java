class Solution {
    public int lengthOfLIS(int[] nums) {
//         n^2 dp
        int dp[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
        }
        int max = 0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
//                 dp[i] will be the last eelemtn
                if(nums[i]>nums[j] && dp[j]+1 > dp[i] ){
                    dp[i]=dp[j]+1;
                }
            }
            
        }
        for (int i = 0; i < nums.length; i++){
            if (max < dp[i]){
                max = dp[i];}}
 
        return max;
    }
}
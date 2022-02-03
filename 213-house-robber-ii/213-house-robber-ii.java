class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2)  return Math.max(nums[0], nums[1]);
        
        int r1 = solve(nums, 0, nums.length-2);
        int r2 = solve(nums,1,nums.length-1);
        return Math.max(r1, r2);
    }
    private int solve(int[]nums, int start, int end){
        if(start==end)return nums[start];
        
        int dp[] = new int[nums.length];
        dp[start]=nums[start];
        dp[start+1] = Math.max(dp[start], nums[start+1]);
        
        for(int i=start+2; i<= end;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[end];
    }
}
class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0,left=nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(left < nums[i] && nums[i]>nums[i+1] || left >nums[i] && nums[i]<nums[i+1]){ //peak or valley
                ans++;
                left = nums[i]; // left most element will ignore the same elements
            }
        }
        return ans;
    }
}
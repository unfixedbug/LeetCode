class Solution {
    public int minOperations(int[] nums, int x) {
            int totalSum = 0;
            for (int num : nums) totalSum += num;
            int targetSum = totalSum - x, currSum = 0, maxSize = -1;
            for (int l = 0, r = 0; r < nums.length; ++r) {
                currSum += nums[r];  
                while (l <= r && targetSum < currSum) {
                    currSum -= nums[l++];
                }
                if (currSum == targetSum) maxSize = Math.max(maxSize, r - l + 1);
            }
            return maxSize == -1 ? -1 : nums.length - maxSize; 
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ans=0;
        int pre=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=nums[pre]){
                nums[++pre] = nums[i];
            }
        }
        return pre+1;
            
    }
}
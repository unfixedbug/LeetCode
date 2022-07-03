class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2)return nums.length;
        int count=2;
        if(nums[0]==nums[1])count=1;
        int prevdiff = nums[1]-nums[0];
        for(int i=2;i<nums.length;i++){
            int currdiff = nums[i]-nums[i-1];
            if((currdiff>0 && prevdiff<=0)||(currdiff<0 && prevdiff>=0)){
                count++;// we have a wiggle sequence
                prevdiff=currdiff;
            }
        }
        return count;
    }
}
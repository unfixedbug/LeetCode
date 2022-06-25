class Solution {
    public boolean checkPossibility(int[] nums) {
        int count=0;
        for(int i=1;i<=nums.length-1 && count <=1;i++){
            if(nums[i-1]>nums[i]){
                count++;// we have to change something now
                // if 3 6 5 6, then we can change, 3 5 5 6, but we have also one non decreasing index, but, what if we changed to 3 6 6 6
                if(i-2<0 || nums[i-2]<=nums[i])nums[i-1]=nums[i];
                else nums[i]=nums[i-1];// same tho
            }
        }
        return count<=1;
    }
}
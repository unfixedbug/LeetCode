class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j){
             if(nums[i]%2>nums[j]%2){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
//             if i even, i++,if j odd j--,
                if(nums[i]%2==0)i++;
                if(nums[j]%2==1)j--;
            //             else swap
               
        }
        return nums;
    }
}
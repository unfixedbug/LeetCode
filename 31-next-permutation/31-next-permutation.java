class Solution {
    public void nextPermutation(int[] nums) {
    //procedure
        //find breakpoint
        // find element greater than the breakpoint
        // swap those indices
        // reverse between the indices
        
        int i1 = nums.length-2;
        while(i1>=0 && nums[i1]>=nums[i1+1]){ // 1 3 5 4 2 .. find 3
            i1--;
        }
        if(i1>=0){// else most increasing sequence
            int i2 = nums.length-1;
            while(nums[i2]<=nums[i1]){// find element just greater than i1th index
                i2--;
            }
            swap(nums,i1,i2);
        }
        reverse(nums,i1+1);// reverse from that index to end/// excluding the index
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
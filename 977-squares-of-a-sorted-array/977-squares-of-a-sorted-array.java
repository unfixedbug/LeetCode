class Solution {
    public int[] sortedSquares(int[] nums) {
//         the two pointer approach
        int n = nums.length;
        int s=0,e = n-1;
        int ans[] = new int[n];
        for(int p = n-1;p>=0;p--){
            if(Math.abs(nums[s]) > Math.abs(nums[e])){
                ans[p]= nums[s]*nums[s];
                s++;
            }else{
                ans[p] = nums[e]*nums[e];
                e--;
            }
        }
        return ans;
    }
}
class Solution {
    public int findMin(int[] nums) {
        return nums[binarySearch(nums)];
    }
    private int binarySearch(int[]nums){
        int l=0,r=nums.length-1;
        int n=nums.length;
        while(l<=r){
            int mid = l +(r-l)/2;
            int next= (mid+1)%n;
                int prev = (mid-1+n)%n;
            if(nums[mid]<=nums[next] && nums[prev]>=nums[mid]){
                return mid;
            }
            else if(nums[0]<=nums[mid]){
                l=mid+1;
            }else if(nums[n-1]>=nums[mid]){
                r=mid-1;
            }
        }
        return 0;
    }
}
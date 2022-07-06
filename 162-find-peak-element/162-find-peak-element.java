class Solution {
    public int findPeakElement(int[] nums) {//
        //promising approach
        int n=nums.length;
        if(n==1)return 0;
        int l=0,r=n-1;
        while(l<=r){
            int mid = l+ (r-l)/2;
            // handle edge cases separately 
            if(mid>0 && mid<n-1){
                // check both elements
                if(nums[mid]>nums[mid+1] && nums[mid-1]<nums[mid]){
                    return mid;
                }else if(nums[mid]<nums[mid+1]){
                    l=mid+1;
                }else r=mid-1;
            }
            else if(mid==0){
                //if, 0th element is big
                if(nums[0]>nums[1])return 0;
                else return 1;
            }
            else {
                if(nums[n-1]>nums[n-2])return n-1;
                else return n-2;
            }
        }
        return 0;
        
    }
}
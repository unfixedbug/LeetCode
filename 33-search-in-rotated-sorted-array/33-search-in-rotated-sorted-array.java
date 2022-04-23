class Solution {
    public int search(int[] nums, int target) {
        int lo=0,hi = nums.length-1;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid]==target)return mid;
            
            if(nums[lo] <= nums[mid]){ // left side of the pivotted array
                if(target >= nums[lo] && target < nums[mid]){ // between lo - mid
                    hi =  mid-1;
                }else{ // between mid-hi
                    lo = mid+1;
                }
            }else{ // right side of the pivoted array
                if(target > nums[mid] && target <=nums[hi]){ // between
                    lo = mid+1;
                } 
                else{
                    hi = mid-1;
                }
            }
        }
        
        return nums[lo]==target ? lo:-1;
    }
    
    
}
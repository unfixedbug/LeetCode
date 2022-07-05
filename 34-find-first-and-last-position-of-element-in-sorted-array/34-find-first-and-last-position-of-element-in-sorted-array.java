class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]={-1,-1};
        if(nums.length==0)return ans;
        ans[0]= binarysearch(nums,target,true);
        if(nums[ans[0]]!=target)return new int[]{-1,-1};
        ans[1]= binarysearch(nums,target,false);
        
        return ans;
    }
    
    private int binarysearch(int[]nums, int target, boolean first){
        int res=0;// possible ans
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){// this can be the possible ans
                res=mid;
                if(first){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else if(nums[mid]>target){
                r=mid-1;
            }else l=mid+1;
        }
        return res;
    }
}
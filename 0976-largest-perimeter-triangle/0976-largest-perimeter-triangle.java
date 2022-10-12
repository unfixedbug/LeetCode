class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int mx= 0;
        next: for(int i=n-1;i>=2;i--){
            for(int j=i-1;j>=1;j--){
                for(int k=j-1;k>=0;k--){
                    if(nums[k]+nums[j]>nums[i]){
                        // mx = Math.max(mx,nums[i]+nums[j]+nums[k]);
                        return nums[i]+nums[j]+nums[k];
                    }else continue next;
                }
            }
        }
        return mx;
    }
}
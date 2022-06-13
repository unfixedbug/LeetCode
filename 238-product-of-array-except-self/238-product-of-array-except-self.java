class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[]= new int[n];
//         prefix sums
        Arrays.fill(res,1);
        for(int i=1;i<n;i++){
            res[i] = res[i-1]*nums[i-1];// ignore this index
        }
//         now suffix
        int suffixprod=1;
        for(int i=n-1;i>=0;i--){
            res[i] *= suffixprod;
            suffixprod *=nums[i];// such that we add this into next iteration
        }
        return res;
    }
}
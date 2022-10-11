class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        if(n<3)return false;
        int fs=Integer.MAX_VALUE,sc=Integer.MAX_VALUE;
        for(int i:nums){
            if(i<=fs)fs=i;
            else if(i<=sc)sc=i;
            else return true;
        }
        return false;
    }
}
class Solution {
    public int smallestRepunitDivByK(int k) {
        int rem=0;
        for(int j=1;j <=k;j++){
            rem = (rem*10+1)%k;
            if(rem==0)return j;
        }
        return -1;
    }
}
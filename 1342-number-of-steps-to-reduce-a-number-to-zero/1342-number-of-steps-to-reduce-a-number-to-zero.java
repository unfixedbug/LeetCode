class Solution {
    public int numberOfSteps(int num) {
        int ans=0;
        if(num==0)return 0;
        while(num!=0){
            ans+= ((num & 1) == 0 ? 1 : 2);
            num>>=1;
        }
        return ans-1;
    }
}
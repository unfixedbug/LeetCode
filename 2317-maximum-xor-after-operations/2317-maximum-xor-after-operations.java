class Solution {
    public int maximumXOR(int[] nums) {
        boolean bitset[] = new boolean [32];
        for(int num:nums){
            int index=0;
            while(num>0){
                if((num&1)==1){
                    bitset[index]=true;
                }
                index++;
                num>>=1;
            }
        }
        
        int ans=0,two=1;
        for(int i=0;i<32;i++){
            if(bitset[i]==true){
                ans+=two;
            }
            two<<=1;
        }
        return ans;
    }
}
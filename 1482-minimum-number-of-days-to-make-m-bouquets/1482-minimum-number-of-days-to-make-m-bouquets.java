class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
    // binary search
        if(m*k>bloomDay.length)return -1;
        int left=1;
        int right = (int)1e9;
        // apply binary search for number of days
        while(left<right){
            int midd = (right + left )/2;
            if(possible(bloomDay,k,m,midd)){
                right = midd;
            }else{
                left = midd+1;
            }
        }
        return right;
        
    }
    
    
    private boolean possible(int bloom[],int k, int m, int day){
        int adjacentCount=0;
        for(int daysNeeded:bloom){
            if(daysNeeded<=day){
                if(++adjacentCount == k){
                    adjacentCount=0;
                    if(--m==0)return true;
                }
            }
            else{
                adjacentCount=0;
            }
        }
        return k==0;
    }
}
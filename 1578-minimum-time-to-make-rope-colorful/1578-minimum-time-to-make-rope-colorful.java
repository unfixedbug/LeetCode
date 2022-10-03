class Solution {
    public int minCost(String col, int[] time) {
        char prev = col.charAt(0);
        int max=time[0];
        int sum=time[0];
        for(int i=1;i<col.length();i++){
            sum+=time[i];
            if(col.charAt(i)==col.charAt(i-1)){
                max = Math.max(max,time[i]);
            }else{
                sum-=max;
                max=time[i];
            }
        }
        return sum-max;
    } 
}
class Solution {
    public int minCost(String col, int[] time) {
        int total=0;
        int i=0,j=0;
        while(i<time.length && j<time.length){
            int curTotal=0,curmax=0;
            
            while(j<time.length && col.charAt(i)==col.charAt(j)){
                curTotal += time[j];
                curmax = Math.max(curmax,time[j]);
                j++;
            }
            total += curTotal-curmax;
            i=j;
        }
        return total;
    } 
}
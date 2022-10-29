class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n=plantTime.length;
        int [][]ps = new int[n][2];
        
        for(int i=0;i<n;i++){
            ps[i][0]=plantTime[i];
            ps[i][1]=growTime[i];
        }
        
        
        //descending order of growTime
        Arrays.sort(ps, (a,b)->b[1]-a[1]);
        
        int t=0,c=0;
        for(int[] pair:ps){
             c += pair[0];
            t = Math.max(t, c + pair[1]);    
        }
        return t;
    }
}
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int curr[] = new int[] {-1,1};
        int result = 0;
        for(int in[]: intervals){
            if(in[0]>curr[0] && in[1]> curr[1]){
                curr[0]=in[0];
                result++;
            }
            curr[1] = Math.max(curr[1], in[1]);
        }
        return result;
    }
}
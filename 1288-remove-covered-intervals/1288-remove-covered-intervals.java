class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int a[], int b[]){
                return a[0]==b[0]?b[1]-a[1]:a[0]-b[0];
            }
        });
        
        int count=0;
        int end,prev_end=0;
        for(int curr[]:intervals){
            end=curr[1];
            if(prev_end<end){
                count++;
                prev_end=end;
            }
        }
        return count;
    }
}
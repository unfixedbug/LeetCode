class Solution {
    public int findMinArrowShots(int[][] points) {
     Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1])); // sort on basis of end point;
     
        int arrow=1, end = points[0][1]; // end of the first ballon
                 
        for(int i=1; i< points.length; i++){
            // starting point of next balloon, is after end             
            if(points[i][0] > end){
                arrow++;
                end = points[i][1];
            }
        }
                 return arrow;
    }
}
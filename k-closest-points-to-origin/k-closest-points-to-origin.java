class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(a,b)-> squareDistance(a)-squareDistance(b));
            
            return Arrays.copyOf(points,k);
    }
    private int squareDistance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}
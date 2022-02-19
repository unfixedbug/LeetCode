class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() -2;i>=0;i--){//bottom up 
            for(int j=0;j<=i;j++){
                //set ith lists, jth block to be the minimum of the  [i+1,j]th, [i+1,j+1]th
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
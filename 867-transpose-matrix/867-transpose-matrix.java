class Solution {
    public int[][] transpose(int[][] matrix) {
        int ans[][] = new int[matrix[0].length][matrix.length];
        int i=matrix.length, j = matrix[0].length;
        for(int row=0;row<i;row++){
            for(int col=0;col<j;col++){
                ans[col][row] = matrix[row][col];
            }
        }
        return ans;
    }
}
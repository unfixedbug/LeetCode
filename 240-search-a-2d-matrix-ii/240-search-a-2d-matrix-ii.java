class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n = matrix[0].length;
        
        int i=0;
        int j=n-1;
        
        while(i<m && j >=0){
            if(matrix[i][j] > target){
                j--; // decrease column
            }
            else if(matrix[i][j] < target){
                i++; // increase row
            }
            else{
                return true;
            }
        }
        return false;
    }
}
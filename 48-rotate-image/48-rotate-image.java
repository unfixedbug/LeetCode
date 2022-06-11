class Solution {
    public void rotate(int[][] matrix) {
        // transpose of matrix, just change, row with the column
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
             int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // reverse tthe row {1 2 3 4 } -> { 4 3 2 1}
        int rs = matrix[0].length; // rowsize
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<rs/2;j++){
                // swap the corner elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][rs-j-1];
                matrix[i][rs-j-1] = temp;
            }
        }
    
    }
}
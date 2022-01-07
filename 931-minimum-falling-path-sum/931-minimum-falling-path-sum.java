class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=1; i<n;i++){
            for(int j=0;j<n;j++){
                // matrix[i][j] = minimum(topleft, top, topright)
                matrix[i][j]+= Math.min(matrix[i-1][Math.max(0,j-1)],    Math.min(matrix[i-1][j] , matrix[i-1][Math.min(j+1,n-1)]));
            }
        }
//         returning the minimum element fron the last row
        return Arrays.stream(matrix[n-1]).min().getAsInt();
    }
}
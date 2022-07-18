class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int row=0;row<n;row++){
            for(int col=1;col<m;col++){
                // calculating the prefix sums for every column
                matrix[row][col] += matrix[row][col-1]; 
            }
        }
        
        int count=0;
        
        //column partitionining
        for(int c1=0;c1<m;c1++){
            for(int c2=c1;c2<m;c2++){
                int sum=0;
                Map<Integer,Integer> map = new HashMap<>();// frequency count of the sum
                map.put(0,1);
                
                // 
                for(int row=0;row<n;row++){
                    sum+=matrix[row][c2];
                    if(c1>0)sum-= matrix[row][c1-1];
                    
                    // 
                    count += map.getOrDefault(sum-target,0);
                    //
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;
        
    }
}
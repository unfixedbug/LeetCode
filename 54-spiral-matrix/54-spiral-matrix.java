class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowend = matrix.length-1;
        int colend = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        if(matrix.length==0){return ans;}
        
        int rowbegin=0,colbegin=0;
        
        while(rowbegin <= rowend && colbegin <= colend){
//             traverse right
            for(int j=colbegin ;j<=colend;j++){// first row
                ans.add(matrix[rowbegin][j]);
            }
            // row done, now decrease the number of rows, remove the first row
            rowbegin ++; // row begins from second
            
            // traverse down
            for(int j=rowbegin;j<=rowend;j++){
                ans.add(matrix[j][colend]);
            }
            // remove the last column, -> 
            colend--;
            
            if(rowbegin <= rowend){
                for(int j=colend;j >=colbegin;j--){
                    ans.add(matrix[rowend][j]);
                }
            }
            rowend--;
            
            //travel up
            if(colbegin <= colend){
                for(int j=rowend;j >=rowbegin ;j--){
                    ans.add(matrix[j][colbegin]);
                }
            }
            colbegin++;
        }
        return ans;
    }   
    
}
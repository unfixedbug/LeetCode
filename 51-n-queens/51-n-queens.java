class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        explore(grid, result, n, 0);
        return result;
    }
    
    void explore(boolean[][] grid, List<List<String>> result, int n, int row){
	    // When queens placed in all rows
        if(n == row){
            result.add(getGridAsListOfStrings(grid));
            return;
        }
        
        for(int i=0; i < n; i++){
            if(canPlaceQueen(grid, row, i, n)){
                grid[row][i] = true;
                explore(grid, result, n, row+1); // Explore next row
                grid[row][i] = false;
            }
        }
    }
    
    boolean canPlaceQueen(boolean[][] grid, int row, int col, int n){
        // Column check
        for(int i=row-1; i >=0; i--)
            if(grid[i][col]) return false;
        
        // Left Upper diagonal Check
        for(int i=row-1, j=col-1; i >=0 && j >= 0; i--, j--)
            if(grid[i][j]) return false;        
        
        // Right Upper diagonal Check
        for(int i=row-1, j=col+1; i >=0 && j < n; i--, j++)
            if(grid[i][j]) return false;
        
        return true;
    }
    
    List<String> getGridAsListOfStrings(boolean[][] grid){
        List<String> ans = new ArrayList<>();
        for(int i=0; i < grid.length; i++){
            StringBuilder currRow = new StringBuilder();
            for(int j=0; j < grid.length; j++){
                if(grid[i][j]) 
                    currRow.append("Q");
                else
                    currRow.append(".");
            }
            ans.add(currRow.toString());
        }
        return ans;
    }
}
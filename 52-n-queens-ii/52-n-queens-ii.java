class Solution {
    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for(char i[]:board){
            Arrays.fill(i,'.');
        }
        int ans = backtrack(0,board); // column, board
        return ans; // answer stores the count
    }
    
    private int backtrack(int col, char[][]board){
        if(col==board.length)return 1;
        int count=0;
        // iterate through all rows
        for(int row =0;row<board.length;row++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                count+=backtrack(col+1,board); // we assume that the arrange ment is ok
                board[row][col]='.'; // remove if it isnt;
            }
        }
        return count;
    }
    private boolean isSafe(char[][]board, int row, int col){
        
        int n  = board.length;
        
        //check upper left diagonal,
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }
        
        // check lower left diagonal
        for(int i=row,j=col;i<n && j>=0;i++,j--){
            if(board[i][j]=='Q')return false;
        }
        
        // check the row
        for(int i=0;i<n;i++){
            if(board[row][i]=='Q')return false;
        }
        
        return true;
    }
}
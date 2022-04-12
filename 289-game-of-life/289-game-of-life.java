class Solution {
    private static final int[][]dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public void gameOfLife(int[][] board){
        var rows = board.length;
        var cols = board[0].length;
        playGame(board, rows, cols);
        updateBoard(board, rows, cols);
    }


    private void playGame(int board[][], int rows, int cols){
        for(var i=0;i<rows;i++){
            for(var j=0;j<cols;j++){
                var alive = aliveNeighbours(board, rows, cols,i,j);
                // dead cell with 3 alive neighbours becomes alive
                if(board[i][j]==0 && alive == 3) // board[i][j] = 00
                    board[i][j]=2; // board[i][j]=10
                else if (board[i][j]==1 && (alive==2 || alive==3)) // board[i][j]=01
                    board[i][j]=3; // board[i][j]=11

            }
        }

    }
    
    private int aliveNeighbours(int [][]board, int rows, int cols, int i, int j){
        var alive=0;
        for(var d:dir){
            var x = i + d[0];
            var y = j + d[1];
            
            if(!isOutOfBound(rows, cols, x, y)) alive += board[x][y]&1;
            // 1 if they are 1, and 0 if neighbours are 0
        }
        return alive;
    }
    
    private boolean isOutOfBound(int rows, int cols, int x, int y){
        return x<0 || x >=rows || y<0 || y>=cols; /// if any of this is true, return true
    }
    
    private void updateBoard(int [][] board, int rows, int cols){
        for(var i=0; i<rows ;i++){
            for(var j=0; j< cols;j++){
                board[i][j] >>=1; /// right shift 1 bot to replace old state with new state
            }
        }
    }
}
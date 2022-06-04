**some column readding output problem -> check out once**
```java
class Solution {
public List<List<String>> solveNQueens(int n) {
boolean [][] board = new boolean[n][n];
List<List<String>> result = new ArrayList<>();
solver(board,result,0);
return result;
}
void solver(boolean[][] board,List<List<String>>result, int col){
if(col==board.length){
result.add(getGridAsListOfStrings(board));
return;
}
for(int row=0;row<board.length;row++){
if(isValid(board,row,col)){
board[row][col]=true;
solver(board,result,col+1);
board[row][col]=false;
}
}
}
private boolean isValid(boolean [][]board,int row,int col){
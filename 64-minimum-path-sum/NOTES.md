**3 types**
a) recursion
```java
public int minPathSum(int[][] grid) {
int n = grid.length;
int m = grid[0].length;
return recursion(n-1,m-1,grid);
}
private int recursion(int i, int j,int[][]grid){
if(i==0 && j==0)return grid[0][0];
if(i<0|| j<0) return Integer.MAX_VALUE;
int up =  recursion(i-1,j,grid); // travelling from upside
int left = recursion(i,j-1,grid); // travelling from righside
return grid[i][j] + Math.min(up,left);
}
```
b) memoization
```java
int dp[][];
public int minPathSum(int[][] grid) {
int n = grid.length;
int m = grid[0].length;
dp = new int[n][m];
for(int a[]:dp){
Arrays.fill(a,-1);
}
return recursion(n-1,m-1,grid);
}
private int recursion(int i, int j,int[][]grid){
if(i==0 && j==0)return grid[0][0];
if(i<0|| j<0) return Integer.MAX_VALUE;
if(dp[i][j]!=-1)return dp[i][j];
int up =  recursion(i-1,j,grid); // travelling from upside
int left = recursion(i,j-1,grid); // travelling from righside
return dp[i][j] = grid[i][j] + Math.min(up,left);
}
```
c) tabulation
[striver op](https://www.youtube.com/watch?v=N_aJ5qQbYA0)
​
**a) recursion** [TLE]
```java
public int minFallingPathSum(int[][] matrix) {
int n=matrix.length;
int m=matrix[0].length;
int ans = Integer.MAX_VALUE;
for(int j=0;j<m;j++){
ans = Math.min(ans,recur(n-1,j,matrix));
}
return ans;
}
private int recur(int i, int j, int[][]matrix){
// out of bound errors
if(j <0 || j>=matrix[0].length)return Integer.MAX_VALUE;
// if reawched the first row, then only
if(i==0)return matrix[0][j];
int up = recur(i-1,j,matrix);
int leftdiagonal = recur(i-1,j-1,matrix);
int rightdiagonal = recur(i-1,j+1,matrix);
return matrix[i][j]+Math.min(up,Math.min(leftdiagonal,rightdiagonal));
}
```
**b) memoization**
```java
​
```
**c) tabulation**
```java
​
```
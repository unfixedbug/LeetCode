int m=matrix[0].length;
dp = new int[n][m];
int ans = Integer.MAX_VALUE;
// fill dp with min value
for(int a[]:dp){
Arrays.fill(a,Integer.MAX_VALUE);
}
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
if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
int up = recur(i-1,j,matrix);
int leftdiagonal = recur(i-1,j-1,matrix);
int rightdiagonal = recur(i-1,j+1,matrix);
return dp[i][j] = matrix[i][j]+Math.min(up,Math.min(leftdiagonal,rightdiagonal));
}
}
```
**c) tabulation**
```java
​
```
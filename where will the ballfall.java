
class Solution1 {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int a[] = new int[n]; // n is the number of columns, so is the number of balls
        for (int i = 0; i < n; i++) {
            a[i] = dfs(grid, 0, i, m, n);
        }
        return a;
    }

    public int dfs(int[][] grid, int i, int j, int m, int n) {
        // check bondary cases
        if ((j < 0) || (j >= n))
            return -1; // out of bound
        if (i >= m)
            return j; // out of bound

        // the ball will go right down
        if (grid[i][j] == 1) {

            if (j < n - 1) {
                if (grid[i][j + 1] == -1) { // will form v, and ball will get blocked
                    return -1;
                }
            }
            // the ball will go down right
            return dfs(grid, i + 1, j + 1, m, n);
        } else {
            if (j > 0) {
                if (grid[i][j - 1] == 1) { // will form v, and ball will get blocked
                    return -1;
                }
            }
            // the ball will go down left
            return dfs(grid, i + 1, j - 1, m, n);
        }
    }
}
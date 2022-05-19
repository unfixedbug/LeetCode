
    class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] outDegrees = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int[] dir : dirs) {
                    int nextX = i + dir[0];
                    int nextY = j + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || matrix[nextX][nextY] <= matrix[i][j]) {
                        continue;
                    }

                    outDegrees[i][j]++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (outDegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int max = 0;
        while (!queue.isEmpty()) {
            max++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                int x = curPos[0];
                int y = curPos[1];
                for (int[] dir : dirs) {
                    int prevX = x + dir[0];
                    int prevY = y + dir[1];

                    if (prevX < 0 || prevX >= row || prevY < 0 || prevY >= col) {
                        continue;
                    }

                    if (matrix[prevX][prevY] >= matrix[x][y]) {
                        continue;
                    }

                    if (--outDegrees[prevX][prevY] == 0) {
                        queue.offer(new int[]{prevX, prevY});
                    }
                }
            }
        }

        return max;
    }
}
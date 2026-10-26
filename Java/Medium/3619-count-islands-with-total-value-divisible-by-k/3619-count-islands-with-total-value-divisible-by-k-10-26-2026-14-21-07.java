
import java.util.*;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int[] dirs = {-1, 0, 1, 0, -1};

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                long sum = 0;

                // Mark visited and push the starting cell
                stack.push(i * n + j);
                sum += grid[i][j];
                grid[i][j] = 0;

                while (!stack.isEmpty()) {
                    int pos = stack.pop();

                    int r = pos / n;
                    int c = pos % n;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dirs[d];
                        int nc = c + dirs[d + 1];

                        if (nr >= 0 && nr < m &&
                            nc >= 0 && nc < n &&
                            grid[nr][nc] > 0) {

                            sum += grid[nr][nc];

                            // Mark before pushing
                            grid[nr][nc] = 0;
                            stack.push(nr * n + nc);
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

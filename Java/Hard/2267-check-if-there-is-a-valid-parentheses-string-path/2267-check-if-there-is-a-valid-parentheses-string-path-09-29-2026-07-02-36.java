class Solution {
    int m, n;
    Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 != 0)
            return false;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        memo = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 0);
    }

    boolean dfs(char[][] grid, int i, int j, int balance) {

        if (i >= m || j >= n)
            return false;

        if (grid[i][j] == '(')
            balance++;
        else
            balance--;

        // Invalid balance
        if (balance < 0)
            return false;

        // Reached destination
        if (i == m - 1 && j == n - 1)
            return balance == 0;

        if (memo[i][j][balance] != null)
            return memo[i][j][balance];

        boolean down = dfs(grid, i + 1, j, balance);
        boolean right = dfs(grid, i, j + 1, balance);

        return memo[i][j][balance] = down || right;
    }
}
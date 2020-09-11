package graphs.solutions.medium;

/**
 * https://leetcode.com/problems/max-area-of-island/
 *
 * https://www.youtube.com/watch?v=W8VuDt0eb5c
 */
public class MaxAreaOfIsland {

    boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        int maxSizeIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && !seen[i][j]) {
                    maxSizeIsland = Math.max(maxSizeIsland, dfs(grid, i, j));
                }
            }
        }
        return maxSizeIsland;
    }

    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
            seen[i][j] || grid[i][j] == 0) {
            return 0;
        }
        seen[i][j] = true;
        int count = 1;
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i, j - 1);
        count += dfs(grid, i, j + 1);

        return count;
    }

}

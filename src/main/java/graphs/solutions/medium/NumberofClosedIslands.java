package graphs.solutions.medium;

/**
 * https://leetcode.com/problems/number-of-closed-islands/
 *
 * https://www.youtube.com/watch?v=MnD8KhBHgRo
 */
public class NumberofClosedIslands {

    public static int closedIsland(int[][] grid) {
        int closedIsland = 0, row = grid.length, column = grid[0].length;

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < column - 1; j++) {
                if (grid[i][j] == 0) {
                    if (isClosedIsaland(grid, i, j, row, column))
                        closedIsland++;
                }

            }
        }
        return closedIsland;
    }

    private static boolean isClosedIsaland(int[][] grid, int i, int j, int row, int column) {

        if (grid[i][j] == 1 || grid[i][j] == -1)
            return true;

        if (isOnPerimeter(i, j, row, column))
            return false;
        grid[i][j] = -1;

        boolean left = isClosedIsaland(grid, i, j - 1, row, column);
        boolean right = isClosedIsaland(grid, i, j + 1, row, column);
        boolean top = isClosedIsaland(grid, i - 1, j, row, column);
        boolean bottom = isClosedIsaland(grid, i + 1, j, row, column);
        return left && right && top && bottom;
    }

    private static boolean isOnPerimeter(int i, int j, int row, int column) {
        return i == 0 || j == 0 || i == row - 1 || j == column - 1;
    }
}

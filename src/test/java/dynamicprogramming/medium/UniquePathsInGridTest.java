package dynamicprogramming.medium;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsInGridTest {

    @Test
    public void uniquePathsWithObstacles() {
        UniquePathsInGrid grid = new UniquePathsInGrid();
        int[][] arr = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        final int pathsWithObstacles = grid.uniquePathsWithObstacles(arr);
        Assert.assertEquals(2,pathsWithObstacles);
    }
}
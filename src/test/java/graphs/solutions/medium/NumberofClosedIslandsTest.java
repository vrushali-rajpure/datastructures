package graphs.solutions.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberofClosedIslandsTest {

    @Test
    public void closedIsland() {

        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        final int closedIsland = NumberofClosedIslands.closedIsland(grid);
        assertEquals(2, closedIsland);
    }
}
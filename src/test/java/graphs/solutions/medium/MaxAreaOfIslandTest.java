package graphs.solutions.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaOfIslandTest {

    @Test
    public void maxAreaOfIsland() {
        MaxAreaOfIsland island = new MaxAreaOfIsland();

        int[][] input = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        assertEquals(4, island.maxAreaOfIsland(input));
    }
}
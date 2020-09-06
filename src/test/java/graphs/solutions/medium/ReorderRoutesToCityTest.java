package graphs.solutions.medium;

import org.junit.Assert;
import org.junit.Test;

public class ReorderRoutesToCityTest {

    @Test
    public void minReorder() {

//        final int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        final int[][] connections = {{1,0},{1,2},{3,2},{3,4}};

        final int minReorder = ReorderRoutesToCity.minReorder(5, connections);

        Assert.assertEquals(2, minReorder);
    }
}
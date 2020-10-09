package graphs.solutions.medium;

import org.junit.Assert;
import org.junit.Test;

public class WallsAndGatesTest {

    @Test
    public void wallsAndGates() {

        int[][] arr = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        WallsAndGates.wallsAndGates(arr);

        int[][] expected = {{3,-1,0,1},{2,2,1,-1},{1,-1,2,-1},{0,-1,3,4}};

        Assert.assertArrayEquals(expected,arr);
    }
}
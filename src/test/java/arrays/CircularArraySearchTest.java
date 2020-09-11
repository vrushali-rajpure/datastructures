package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularArraySearchTest {

    @Test
    public void circularArraySearch() {
        int[] A = {9, 10, 2, 5, 6, 8};
        int key = 10;

        int index = CircularArraySearch.circularArraySearch(A, key);

        assertEquals(3,index);
    }
}
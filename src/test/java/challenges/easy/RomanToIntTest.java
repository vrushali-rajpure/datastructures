package challenges.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToIntTest {

    @Test
    public void testRomanToInt() {
        final int iv = RomanToInt.romanToInt("DCXXI");

        //DCXXI  500 + 100 +  10 + 10 + 1 : 621
        assertEquals(iv,621);
    }
}
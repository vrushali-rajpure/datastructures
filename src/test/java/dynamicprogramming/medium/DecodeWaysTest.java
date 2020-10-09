package dynamicprogramming.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeWaysTest {

    @Test
    public void numDecodings() {
        final int decodings = DecodeWays.numDecodings("12");
        assertEquals(2, decodings);
    }
}
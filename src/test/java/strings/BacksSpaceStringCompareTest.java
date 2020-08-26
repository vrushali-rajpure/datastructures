package strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class BacksSpaceStringCompareTest {

    @Test
    public void backspaceCompare() {
//        "y#fo##f"
//        "y#f#o##f"

        assertTrue(BacksSpaceStringCompare.backspaceCompare("y#fo##f","y#f#o##f"));
    }
}
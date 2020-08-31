package stack.solutions.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumFrequencyStackTest {

    @Test
    public void testStack() {
        MaximumFrequencyStack stack = new MaximumFrequencyStack();
        stack.push(1);
        stack.push(1);
        stack.push(2);

        assertEquals(1,stack.pop());
    }
}
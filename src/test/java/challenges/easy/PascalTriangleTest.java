package challenges.easy;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class PascalTriangleTest {

    @Test
    public void test() {
        final List<List<Integer>> generate = PascalTriangle.generate(5);
        System.out.println(generate);
    }
}
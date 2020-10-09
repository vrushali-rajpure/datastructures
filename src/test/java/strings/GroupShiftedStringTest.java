package strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class GroupShiftedStringTest {

    @Test
    public void groupStrings() {

        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        String[][] output = {{"a", "z"}, {"az", "ba"}, {"acef"}, {"abc", "bcd", "xyz"}};

        final List<List<String>> result = GroupShiftedString.groupStrings(input);

        final String expected = Arrays.stream(output)
            .map(Arrays::toString)
            .collect(Collectors.joining(","));

//        Arrays.toString(output);
        Assert.assertEquals(
            expected, result.toString());
    }
}
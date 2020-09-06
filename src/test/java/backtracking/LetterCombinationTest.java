package backtracking;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class LetterCombinationTest {

    @Test
    public void letterCombinations() {
        LetterCombinationOfPhoneNumber combination = new LetterCombinationOfPhoneNumber();

        final List<String> strings = combination.letterCombinations("23");
        Assert.assertEquals(9,strings.size());
    }
}
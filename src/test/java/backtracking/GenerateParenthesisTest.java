package backtracking;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateParenthesisTest {

    @Test
    public void shouldGenerateParethesis() {
        GenerateParenthesis parenthesis = new GenerateParenthesis();

        final List<String> result = parenthesis.generateParenthesis(2);

        System.out.println(result);
        assertEquals(2,result.size());
    }
}
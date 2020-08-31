package challenges.hard;

import org.junit.Test;

public class BasicCalculatorTest {

    @Test
    public void doCalculation() {
        BasicCalculator calculator = new BasicCalculator();
        String S = "(()(()))";
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0)
                sb.append(c);
            if (c == ')' && opened-- > 1)
                sb.append(c);
        }
        System.out.println(sb.toString());
//        assertEquals(3, calculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
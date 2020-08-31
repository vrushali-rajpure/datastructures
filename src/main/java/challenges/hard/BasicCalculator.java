package challenges.hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//TODO : Unsolved
// https://leetcode.com/problems/basic-calculator/solution/
/**
 * https://leetcode.com/problems/basic-calculator/
 *
 */
public class BasicCalculator {

    public int calculate(String s) {

        final char[] chars = s.toCharArray();
        int result = 0;
        Queue<Character> op = new LinkedList<>();
        Stack<Integer> operands = new Stack<>();
        for (char aChar : chars) {
            if( isOperator(aChar)){
                op.add(aChar);
            } else if( Character.isDigit(aChar)){
                operands.push(Character.digit(aChar,10));
            }
        }

        while (!op.isEmpty()) {
            final Integer op1 = operands.pop();
            final Integer op2 = operands.pop();

            final Character pop = op.poll();

            switch (pop) {
                case '+':
                        result = op1 + op2;
                        break;

                case '-':
                    result = op1 - op2;
                    break;
            }

            if( !op.isEmpty()) {
                operands.push(result);
            }
        }

        return result;

    }

    boolean isOperator(char ch) {
        return ch == '-' || ch == '+';
    }
}

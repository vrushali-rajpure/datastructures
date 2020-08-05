import java.util.Stack;

public class PostFixEvaluation {


    static int evaluate(String expression) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            final char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(c+""));
            }
            else {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                final int evaluate = evaluate(c, leftOperand, rightOperand);
                stack.push(evaluate);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        final int evaluate = evaluate("123*+5-");
        System.out.println(evaluate);
    }

    private static boolean isOperator(char c) {
        return !Character.isAlphabetic(c);
    }

    private static int evaluate(char c, int left, int right) {
        switch (c) {
            case '+':
                return left + right;

            case '-':
                return left - right;

            case '*':
                return left * right;

            case '/':
                return left / right;
        }
        throw new IllegalArgumentException("invalid operator");
    }

}

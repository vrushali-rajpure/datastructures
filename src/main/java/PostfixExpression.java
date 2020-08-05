import java.util.Stack;

/*
If the character is an operand, add it to the result.
If the character is an operator.
    If the operator stack is empty then push it to the operator stack.
    Else If the operator stack is not empty,
        If the operator’s precedence is greater than or equal to the precedence of the stack top of the operator stack, then push the character to the operator stack.
        If the operator’s precedence is less than the precedence of the stack top of operator stack then “pop out an operator from the stack and add it to the result until the stack is empty or operator’s precedence is greater than or equal to the precedence of the stack top of operator stack“. then push the operator to stack.
If the character is “(“, then push it onto the operator stack.
If the character is “)”, then “pop out an operator from the stack and add it to the result until the corresponding “(“ is encountered in operator stack. Now just pop out the “(“.
 */
public class PostfixExpression {

    public static void main(String[] args) {
        convertToPostFix("A*B-(C+D)+E");
    }

    static void convertToPostFix(String expression) {
        Stack<Character> stack = new Stack<>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            final char c = expression.charAt(i);
            if (isOperand(c)) {
                builder.append(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();

            } else if (c == '(') {
                stack.push(c);
            } else {
                while (!stack.empty() && precedence(stack.peek()) >= precedence(c)) {
                    builder.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        System.out.println(builder.toString());

    }

    private static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}

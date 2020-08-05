import java.util.Stack;

/*
Iterate through given expression, one character at a time

If the character is an operand, push it to the operand stack.
If the character is an operator,
    If the operator stack is empty then push it to the operator stack.
    Else If the operator stack is not empty,
        If the character’s precedence is greater than or equal to the precedence of the stack top of the operator stack, then push the character to the operator stack.
        If the character’s precedence is less than the precedence of the stack top of the operator stack then do Process (as explained above) until character’s precedence is less or stack is not empty.
If the character is “(“, then push it onto the operator stack.
If the character is “)”, then do Process (as explained above) until the corresponding “(” is encountered in operator stack. Now just pop out the “(“.
 */
public class InfixEvaluation {

    static int evaluate(String expression) {

        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOperator(c)) {
                while (!operator.isEmpty() && precedence(c) <= precedence(operator.peek())) {
                    int output = performOperation(operand, operator);
                    //push it back to stack
                    operand.push(output);
                }
                operator.push(c);
            } else if (Character.isDigit(c)) {
                //Entry is Digit, it could be greater than one digit number
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < expression.length())
                        c = expression.charAt(i);
                    else
                        break;
                }
                i--;
                //push it into stack
                operand.push(num);
            } else if (c == '(') {
                //push it to operators stack
                operator.push(c);
            } else if (c == ')') {
                while (operator.peek() != '(') {
                    int output = performOperation(operand, operator);
                    //push it back to stack
                    operand.push(output);
                }
                operator.pop();
            }

        }
        while(!operator.isEmpty()){
            int output = performOperation(operand, operator);
            //push it back to stack
            operand.push(output);
        }
        return operand.pop();
    }

    public static void main(String[] args) {

        final int evaluate = evaluate("(3+5)-(1+2)");
        System.out.println(evaluate);
    }

    static int precedence(char c) {
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

    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
    }

    static int performOperation(Stack<Integer> numbers, Stack<Character> operations) {
        int a = numbers.pop();
        int b = numbers.pop();
        char operation = operations.pop();
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new
                        UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0;
    }
}

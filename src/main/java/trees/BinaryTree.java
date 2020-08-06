package trees;

import java.util.Stack;

//class BinaryTreeNode1 {
//    char ch;
//    BinaryTreeNode1 left, right;
//
//    public BinaryTreeNode1(char ch) {
//        this.ch = ch;
//    }
//
//    @Override public String toString() {
//        return "{" +
//            "ch=" + ch +
//            ", left=" + left.ch +
//            ", right=" + right.ch +
//            '}';
//    }
//}

public class BinaryTree {

    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^');
    }

    static BinaryTreeNode buildExpressionTreeFromPostFix(char[] postfixExpr, int size) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        for (final char ch : postfixExpr) {
            BinaryTreeNode node = new BinaryTreeNode(ch);
            if (isOperator(ch)) {
                BinaryTreeNode right = stack.pop();
                node.left = stack.pop();
                node.right = right;
            }
            stack.push(node);

        }

        return stack.pop();
    }
}

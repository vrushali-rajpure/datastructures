package trees;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void buildExpressionTree() {
        char ch[] = {'A', 'B', 'C', '*', '+', 'D', '/'};
        final BinaryTreeNode expressionTreeFromPostFix = BinaryTree.buildExpressionTreeFromPostFix(ch, 7);

        System.out.println(expressionTreeFromPostFix);
    }
}
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void buildExpressionTree() {
        char ch[] = {'A','B','C','*','+','D','/'};
        final BinaryTreeNode1 expressionTreeFromPostFix = BinaryTree.buildExpressionTreeFromPostFix(ch, 7);

        System.out.println(expressionTreeFromPostFix);
    }
}
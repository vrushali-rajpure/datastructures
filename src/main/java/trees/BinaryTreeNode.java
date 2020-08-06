package trees;

public class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    @Override public String toString() {
        return "{" +
            "data=" + data +
            '}';
    }

}

package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/ Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#] Explanation: Given the above binary tree (Figure A), your function should populate each
 * next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as
 * connected by the next pointers, with '#' signifying the end of each level.
 * <p>
 * <p>
 * Solution : classical case of level order traversal
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    @Override public String toString() {
        return "{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            ", next=" + next +
            "}\n";
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Node))
            return false;
        Node node = (Node) o;
        return val == node.val &&
            Objects.equals(left, node.left) &&
            Objects.equals(right, node.right) &&
            Objects.equals(next, node.next);
    }

    @Override public int hashCode() {
        int result = val;
        result = 31 * result + left.hashCode();
        result = 31 * result + right.hashCode();
        result = 31 * result + next.hashCode();
        return result;
    }
}

public class PopulateNextRightPointersEachNode {

    static Node createInput() {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, null, node7, null);
        return new Node(1, node2, node3, null);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final Node connect = solution.connect(createInput());
        final boolean equals = Objects.equals(connect, expectedOutput());
        System.out.println("Result :" + equals);
    }

    static Node expectedOutput() {
        Node node7 = new Node(7);
        Node node5 = new Node(5, null, null, node7);
        Node node4 = new Node(4, null, null, node5);
        Node node3 = new Node(3, null, node7, null);
        Node node2 = new Node(2, node4, node5, node3);
        return new Node(1, node2, node3, null);
    }

}

class Solution {
    public Node connect(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Node> currentLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            final Node element = queue.poll();
            if (null != element) {
                currentLevel.add(element);
                if (element.left != null) {
                    queue.offer(element.left);
                }

                if (element.right != null) {
                    queue.offer(element.right);
                }

            } else {
                int index = 0;
                while ((index + 1) < currentLevel.size()) {
                    final Node node = currentLevel.get(index);
                    final Node nextNode = currentLevel.get(index + 1);
                    node.setNext(nextNode);
                    index++;
                }

                currentLevel.clear();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        return root;
    }
}


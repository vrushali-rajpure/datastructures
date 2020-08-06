package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * https://leetcode.com/problems/house-robber-iii/
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the
 * "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that
 * "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked
 * houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 *  Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * <p>
 *  Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * <p>
 * Output: 9 Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {


    static BinaryTreeNode createInputI() {
        BinaryTreeNode node4 = new BinaryTreeNode(1);
        BinaryTreeNode node5 = new BinaryTreeNode(3);
        BinaryTreeNode node7 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(4, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(5, null, node7);
        return new BinaryTreeNode(3, node2, node3);
    }

    static BinaryTreeNode createInputII() {
        BinaryTreeNode node5 = new BinaryTreeNode(3);
        BinaryTreeNode node7 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2, null, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        return new BinaryTreeNode(3, node2, node3);
    }

    public static void main(String[] args) {
        final int countNodes = new HouseRobberIII().rob(createInputI());
        System.out.println(countNodes);
        final boolean equals = Objects.equals(9, countNodes);
        System.out.println("ResultI:" + equals);

        final int countNodesII = new HouseRobberIII().rob(createInputII());
        System.out.println(countNodes);
        final boolean equalsII = Objects.equals(7, countNodesII);
        System.out.println("ResultII :" + equalsII);
    }

    public int rob(BinaryTreeNode root) {

        final ArrayList<ArrayList<Integer>> result = LevelOrderTraversal.levelOrderTraversal(root);

        AtomicInteger index = new AtomicInteger();
        final List<LevelInfo> levelInfos = result
            .stream()
            .map(eachLevel -> {
                    final Integer count = eachLevel.stream().reduce(0, Integer::sum);
                    return new LevelInfo(index.getAndIncrement(), count, eachLevel);
                }
            ).collect(Collectors.toList());

        final Integer even = levelInfos.stream().filter(levelInfo -> levelInfo.levelNo % 2 == 0)
            .map(levelInfo -> levelInfo.count)
            .reduce(0, Integer::sum);

        final Integer odd = levelInfos.stream().filter(levelInfo -> levelInfo.levelNo % 2 != 0)
            .map(levelInfo -> levelInfo.count)
            .reduce(0, Integer::sum);

        return even > odd ? even : odd;
    }

    static class LevelInfo {
        int levelNo;
        int count;
        List<Integer> elements;

        public LevelInfo(int levelNo, int count, List<Integer> elements) {
            this.levelNo = levelNo;
            this.count = count;
            this.elements = elements;
        }
    }

}

package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.swing.tree.TreeNode;

/**
 * Will not compile
 */
public class HouseRobberSubmissionCode {

    public int rob(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            final TreeNode temp = queue.poll();
            if (temp != null) {
                curr.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            } else {
                ArrayList<Integer> c_curr = new ArrayList<>(curr);
                result.add(c_curr);
                curr.clear();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

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

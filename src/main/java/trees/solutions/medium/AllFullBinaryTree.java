package trees.solutions.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import trees.BinaryTreeNode;

public class AllFullBinaryTree {

    public List<BinaryTreeNode> allPossibleFBT(int N,String n) {
        System.out.println("input N:" + N + "...n:" + n);
        Map<Integer, List<BinaryTreeNode>> memo = new HashMap<>();
        if (!memo.containsKey(N)) {
            List<BinaryTreeNode> ans = new LinkedList<>();
            if (N == 1) {
                ans.add(new BinaryTreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    System.out.println("X:" + x);
                    int y = N - 1 - x;
                    System.out.println("Y:" + y);

                    for (BinaryTreeNode left : allPossibleFBT(x,"left"))
                        for (BinaryTreeNode right : allPossibleFBT(y,"right")) {
                            BinaryTreeNode bns = new BinaryTreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
            System.out.println("memo :" + memo);
            System.out.println(" ");
        }

        return memo.get(N);
    }
}

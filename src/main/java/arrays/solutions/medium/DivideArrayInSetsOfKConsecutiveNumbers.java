package arrays.solutions.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    public static boolean isPossibleDivide(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            final int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(map.keySet());

        while (!queue.isEmpty()) {
            final Integer poll = queue.peek();
            if (!map.containsKey(poll)) {
                queue.remove();
            } else {
                for (int i = poll; i < poll + k; i++) {
                    if (!map.containsKey(i)) {
                        return false;
                    }
                    int count = map.get(i);
                    if (count - 1 == 0) {
                        map.remove(i);
                    } else {
                        map.put(i, count - 1);
                    }
                }
            }

        }
        return true;

    }
}

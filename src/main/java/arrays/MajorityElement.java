package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * https://leetcode.com/problems/majority-element/submissions/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num) != null ? map.get(num) + 1 : 1;
            map.put(num, count);
        }

        final Optional<Map.Entry<Integer, Integer>> max = map.entrySet().stream().max(Map.Entry.comparingByValue());

        return max.get().getKey();

    }
}

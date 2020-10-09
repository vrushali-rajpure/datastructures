package challenges.medium;

import java.util.TreeMap;

/**
 * Alice has a hand of cards, given as an array of integers.
 *
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 *
 * Return true if and only if she can.
 *
 *
 *
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 *
 * https://leetcode.com/problems/hand-of-straights/
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {


        TreeMap<Integer,Integer> map = new TreeMap();
        for(int num : hand) {
            if(map.containsKey(num)){
                map.replace(num,map.get(num) + 1);
            } else {
                map.put(num,1);
            }
        }

        while(!map.isEmpty()) {
            int first = map.firstKey();
            for(int i = first; i < first + W; i++) {
                if(!map.containsKey(i))
                    return false;

                int count = map.get(i);
                if( count == 1){
                    map.remove(i);
                } else {
                    map.replace(i,count - 1);
                }
            }
        }

        return true;

    }
}

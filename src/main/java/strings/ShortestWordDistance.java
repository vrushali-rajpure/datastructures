package strings;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * https://leetcode.com/problems/shortest-word-distance/
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {

        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                i1 = i;

            if (words[i].equals(word1))
                i2 = i;

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
            
        }
        return minDistance;
    }
}

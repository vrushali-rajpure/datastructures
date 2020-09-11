package priorityqueues.solutions.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeaderBoardDesign {

    Map<Integer, Integer> map;

    public LeaderBoardDesign() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        queue.addAll(map.values());
        int sum = 0;
        while (!queue.isEmpty() && K > 0) {
            sum += queue.poll();
            K--;
        }
        return sum;
    }

    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
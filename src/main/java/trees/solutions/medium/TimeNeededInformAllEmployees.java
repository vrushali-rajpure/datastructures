package trees.solutions.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Needed to Inform All Employees
 *
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */
public class TimeNeededInformAllEmployees {

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> subordinates = new ArrayList<>();

        for (int i = 0; i < manager.length; i++) {
            subordinates.add(new ArrayList<>());
        }

        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1)
                continue;

            subordinates.get(manager[i]).add(i);
        }

        return dfs(headID, subordinates, informTime);
    }

    private static int dfs(int current, List<List<Integer>> subordinates, int[] informTime) {
        int maxTime = 0;

        for (Integer subs : subordinates.get(current)
        ) {
            maxTime = Math.max(maxTime, dfs(subs, subordinates, informTime));
        }
        return informTime[current] + maxTime;
    }
}

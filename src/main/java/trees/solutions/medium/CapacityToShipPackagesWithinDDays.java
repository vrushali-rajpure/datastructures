package trees.solutions.medium;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * https://www.youtube.com/watch?v=CoNBRq5JSz0
 *
 *
 */
public class CapacityToShipPackagesWithinDDays {

    public static int shipWithinDays(int[] weights, int D) {

        int min = 0, max = 0;

        for (int weight : weights) {
            min = Math.max(weight,min);
            max += weight;
        }

        int retVal = 0;
        while (min <= max) {
            int mid = (min + max) / 2;

            final int daysWithCapacity = divideWithCapacity(mid, weights);

            if (daysWithCapacity > D) {
                min = mid + 1;
            } else {
                retVal = mid;
                max = mid - 1;
            }

        }

        return retVal;
    }

    private static int divideWithCapacity(int mid, int[] weights) {
        int days = 1;
        int currentCapacity = 0;
        for (int weight : weights) {
            currentCapacity += weight;
            if (currentCapacity > mid) {
                days++;
                currentCapacity = weight;
            }
        }

        return days;

    }

}

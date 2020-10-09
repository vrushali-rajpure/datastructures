package challenges.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 */
class MovingAverage {

   /*

   Time Complexity:  O(N) where N is the size of the moving window, since we need to retrieve NN elements from the queue at each invocation of next(val) function.
    Space Complexity: O(M), where M is the length of the queue which would grow at each invocation of the next(val) function.
    */
    int windowSize;
    List<Integer> list = new ArrayList<>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        windowSize = size;
    }

    public double next(int val) {
        list.add(val);
        int sum = 0;
        for (int i = Math.max(0, list.size() - windowSize); i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum * 1.0 / Math.min(list.size(), windowSize);
    }

    public static void main(String[] args) {
        MovingAverage average = new MovingAverage(3);
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));
    }
}

class MovingAverageWithDeque {
    /**
     * Time Complexity:  O(1), as we explained in intuition.
     * Space Complexity:  O(N), where N is the size of the moving window.
     */
    int windowSize;
    int sum = 0;
    int count = 0;
    Deque<Integer> queue = new ArrayDeque<>();

    public MovingAverageWithDeque(int windowSize) {
        this.windowSize = windowSize;
    }

    public double next(int val) {
        count++;
        queue.offer(val);

        int tail = count > windowSize ? (int)queue.poll() : 0;

        sum = sum - tail + val;

        return sum * 1.0 / Math.min(windowSize, count);

    }

    public static void main(String[] args) {
        MovingAverageWithDeque average = new MovingAverageWithDeque(3);
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));

        System.out.println("--------");
        System.out.println(1 - 3 + 4);
    }
}


package arrays;

import java.util.Stack;

public class BasketBallChallenge {
    public int calPoints(String[] ops) {

        Stack<Integer> validScore = new Stack<>();

        int sum = 0;

        for (final String string : ops) {

            int score;
            if (string.equalsIgnoreCase("+")) {
                final Integer last = validScore.pop();
                Integer secondLast = validScore.pop();
                sum += last + secondLast;
                validScore.push(secondLast);
                validScore.push(last);
                validScore.push(last + secondLast);
            } else if (string.equalsIgnoreCase("D")) {
                final Integer last = validScore.peek();
                sum += last * 2;
                validScore.push(last * 2);
            } else if (string.equalsIgnoreCase("C")) {
                final Integer last = validScore.pop();
                sum -= last;
            } else {
                score = Integer.parseInt(string);
                sum += score;
                validScore.push(score);
            }

        }
        return sum;
    }

}

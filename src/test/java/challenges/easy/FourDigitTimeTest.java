package challenges.easy;

import org.junit.Test;

public class FourDigitTimeTest {

    @Test
    public void largestTimeFromDigits() {
        FourDigitTime fdigit = new FourDigitTime();
//        final String digits = fdigit.largestTimeFromDigits(new int[] {2, 4, 3, 1});
//        final String digits = fdigit.largestTimeFromDigits(new int[] {5,5,5,5});
//        final String digits = fdigit.largestTimeFromDigits(new int[] {4,2,4,4});
        final String digits = fdigit.largestTimeFromDigits(new int[] {2, 0, 6, 6});

        System.out.println(digits);
    }
}
package trees.solutions.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeNeededInformAllEmployeesTest {

    @Test
    public void numOfMinutes() {
        int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] informTime = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        final int minutes = TimeNeededInformAllEmployees.numOfMinutes(15, 0, manager, informTime);

        assertEquals(3, minutes);
    }
}
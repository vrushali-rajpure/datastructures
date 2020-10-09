package trees.solutions.medium;

import org.junit.Assert;
import org.junit.Test;

public class CapacityToShipPackagesWithinDDaysTest {

    @Test
    public void shipWithinDays() {

        int[] weight = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int days = CapacityToShipPackagesWithinDDays.shipWithinDays(weight, 5);

        Assert.assertEquals(15, days);


    }
}
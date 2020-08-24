package challenges.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

public class EmployeeImportanceTest {

    @Test
    public void getImportance() {
        //[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1

        final List<Employee> employees = asList(new Employee(1, 5, asList(2, 3)),
            new Employee(2, 3, emptyList()),
            new Employee(3, 3, emptyList()));

        final int importance = EmployeeImportance.getImportance(employees, 1);
        assertEquals(11,importance);
    }

    @Test
    public void testGetImportanceByDFS() {
        final List<Employee> employees = asList(new Employee(1, 5, asList(2, 3)),
            new Employee(2, 3, emptyList()),
            new Employee(3, 3, emptyList()));

        final int importance = EmployeeImportance.getImportanceByDFS(employees, 1);
        assertEquals(11,importance);

    }
}
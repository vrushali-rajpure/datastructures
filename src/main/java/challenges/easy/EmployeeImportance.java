package challenges.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 *
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.
 *
 * Example 1:
 *
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 *
 * https://leetcode.com/problems/employee-importance/
 */

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};

public class EmployeeImportance {

    static Map<Integer, Employee> emap;

    public static void main(String[] args) {
        final List<String> collect = Stream.of("one", "two", "three", "four")
            .filter(e -> e.length() > 3)
            .peek(e -> System.out.println("Filtered value: " + e))
            .map(String::toUpperCase)
            .peek(e -> System.out.println("Mapped value: " + e))
            .collect(Collectors.toList());

        System.out.println(collect);
    }

    public static int getImportance(List<Employee> employees, int id) {

        final Optional<Employee> first = employees
            .stream()
            .filter(employee -> employee.id == id)
            .findFirst();

        if (!first.isPresent()) {
            return 0;
        }
        final Employee employee = first.get();
        final List<Integer> subordinates = employee.subordinates;
        int sum = employee.importance;
        for (Integer subordinate : subordinates) {
            sum += getImportance(employees, subordinate);
        }

        return sum;
    }
    public static int getImportanceByDFS(List<Employee> employees, int id) {

        emap = new HashMap<>();

        for (Employee employee : employees) {
            emap.put(employee.id, employee);
        }
        return dfs(id);
    }

    private static int dfs(int id) {
        final Employee employee = emap.get(id);
        int ans = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            ans += dfs(subordinate);
        }

        return ans;
    }

}

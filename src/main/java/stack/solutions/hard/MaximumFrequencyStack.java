package stack.solutions.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 *
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 *
 * FreqStack has two functions:
 *
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 */
public class MaximumFrequencyStack {
    int maxFre;
    Map<Integer,Integer> fre = new HashMap<>();
    Map<Integer, Stack<Integer>> group = new HashMap<>();

    public void push(int x) {

        final int value = fre.getOrDefault(x, 0) + 1;
        fre.put(x,value);
        if(value> maxFre ) {
            maxFre = value;
        }
        group.computeIfAbsent(value, z-> new Stack<>()).push(x);

    }

    public int pop() {
        final Integer pop = group.get(maxFre).pop();
        fre.put(pop,maxFre-1);
        if (group.get(maxFre).size() == 0)
            maxFre--;
        return pop;
    }
}

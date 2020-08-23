package de.ts.codility.lesson3;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 * <p>
 * A small frog wants to get to the other side of the road.
 * The frog is currently located at position X and wants to get to a position greater than or equal to Y.
 * The small frog always jumps a fixed distance, D.
 * <p>
 * Count the minimal number of jumps that the small frog must perform to reach its target.
 * <p>
 * Write a function:
 * <p>
 * that, given three integers X, Y and D, returns the minimal number of jumps
 * from position X to a position equal to or greater than Y.
 * <p>
 * Complexity time: O(1)
 * Complexity space: O(1)
 */
public class FrogJmp {

    public int solution(int start, int target, int jumpRange) {

        int distance = target - start;

        return (distance + jumpRange - 1) / jumpRange;
    }
}

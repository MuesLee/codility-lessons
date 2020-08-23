package de.ts.codility.lesson4;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 * <p>
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * <p>
 * Write a function:
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers,
 * returns a sequence of integers representing the values of the counters.
 * <p>
 * Complexity time: O(n + m)
 * Complexity space: O(n)
 */
public class MaxCounters {

    public int[] solution(int slotCount, int[] operations) {

        int[] counters = new int[slotCount];

        int propagatedMaxValue = 0;
        int currentMaxValue = 0;

        for (int operation : operations) {
            if (operation == slotCount + 1) {
                propagatedMaxValue = currentMaxValue;
                continue;
            }

            int counterIndex = operation - 1;
            int slotValue = counters[counterIndex];

            if (slotValue < propagatedMaxValue) {
                slotValue = propagatedMaxValue;
            }

            slotValue++;

            counters[counterIndex] = slotValue;
            currentMaxValue = Math.max(slotValue, currentMaxValue);
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < propagatedMaxValue) {
                counters[i] = propagatedMaxValue;
            }
        }

        return counters;
    }
}

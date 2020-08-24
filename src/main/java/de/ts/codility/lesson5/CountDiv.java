package de.ts.codility.lesson5;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 * <p>
 * Write a function:
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * <p>
 * Complexity time: O(1)
 * Complexity space: O(1)
 */
public class CountDiv {

    public int solution(int rangeStartInclusive, int rangeEndInclusive, int divisor) {
        if (rangeEndInclusive == 0) {
            return 1;
        }

        int remainderStart = rangeStartInclusive % divisor;

        if (remainderStart > 0) {
            rangeStartInclusive = rangeStartInclusive + divisor - remainderStart;
        }

        if (rangeStartInclusive > rangeEndInclusive) {
            return 0;
        }

        return (rangeEndInclusive - rangeStartInclusive) / divisor + 1;
    }
}

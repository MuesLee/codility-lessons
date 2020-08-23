package de.ts.codility.lesson3;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * <p>
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N,
 * splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of:
 * |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * <p>
 * Write a function:
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(1)
 */
public class TapeEquilibrium {

    public int solution(int[] a) {
        long sumLeft = a[0];
        long sumRight = Arrays.stream(a).asLongStream().skip(1).sum();
        long minDifference = Math.abs(sumLeft - sumRight);

        for (int i = 1; i < a.length - 1; i++) {
            int number = a[i];
            sumLeft += number;
            sumRight -= number;

            long difference = Math.abs(sumLeft - sumRight);
            minDifference = Math.min(minDifference, difference);
        }

        return Math.toIntExact(minDifference);
    }
}

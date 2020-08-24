package de.ts.codility.lesson6;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 * <p>
 * Write a function
 * <p>
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class Distinct {

    public int solution(int[] array) {
        return (int) Arrays.stream(array).distinct().count();
    }
}

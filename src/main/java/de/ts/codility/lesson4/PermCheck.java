package de.ts.codility.lesson4;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * is a permutation, but array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * <p>
 * Complexity time: O(n + log(n))
 * Complexity space: O(n)
 */
public class PermCheck {

    public int solution(int[] array) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return 0;
            }
        }

        return 1;
    }
}

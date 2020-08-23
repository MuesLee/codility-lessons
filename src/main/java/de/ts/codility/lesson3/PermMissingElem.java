package de.ts.codility.lesson3;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 * <p>
 * An array A consisting of N different integers is given.
 * The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * that, given an array A, returns the value of the missing element.
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(1)
 */
public class PermMissingElem {

    public int solution(int[] a) {

        long rangeEnd = a.length + 1;
        long rangeMaxSum = ((rangeEnd + 1) * rangeEnd) / 2;

        for (int number : a) {
            rangeMaxSum -= number;
        }

        return (int) rangeMaxSum;
    }
}

package de.ts.codility.lesson4;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 * <p>
 * Write a function:
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(100000)
 */
public class MissingInteger {

    public int solution(int[] array) {

        boolean[] numberIsPresent = new boolean[1000000];

        for (int i : array) {
            if (i > 0) {
                numberIsPresent[i - 1] = true;
            }
        }

        for (int i = 0; i < numberIsPresent.length; i++) {
            if (!numberIsPresent[i]) {
                return i + 1;
            }
        }

        return 1000001;
    }
}

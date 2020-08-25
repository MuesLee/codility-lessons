package de.ts.codility.lesson8;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/8-leader/dominator/
 * <p>
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A
 * (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * that, given an array A consisting of N integers, returns index of any element
 * of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 * <p>
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class Dominator {

    public int solution(int[] givenArray) {

        if (givenArray.length < 1) {
            return -1;
        }

        int[] array = Arrays.copyOf(givenArray, givenArray.length);
        Arrays.sort(array);

        int lastCount = 0;

        int currentNumber = array[0];
        int currentCount = 0;

        int maxCount = 0;
        int maxNumber = array[0];

        for (int value : array) {
            if (value == currentNumber) {
                currentCount++;
            } else {
                if (currentCount > lastCount) {
                    maxCount = currentCount;
                    maxNumber = currentNumber;
                }

                lastCount = currentCount;
                currentCount = 1;
                currentNumber = value;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxNumber = currentNumber;
        }

        if ((double) array.length / 2 < maxCount) {
            return Arrays.binarySearch(givenArray, maxNumber);
        }

        return -1;
    }
}

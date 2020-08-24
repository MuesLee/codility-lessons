package de.ts.codility.lesson6;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 * <p>
 * A non-empty array A consisting of N integers is given.
 * The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * contains the following example triplets:
 * <p>
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 * <p>
 * Write a function:
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * <p>
 * Complexity time: O(n log(n))
 * Complexity space: O(n)
 */
public class MaxProductOfThree {

    public int solution(int[] array) {

        Arrays.sort(array);

        int lowestValue = array[0];
        int secondLowestValue = array[1];

        int highestValue = array[array.length - 1];
        int secondHighestValue = array[array.length - 2];
        int thirdHighestValue = array[array.length - 3];

        int productOfHighestThree = highestValue * secondHighestValue * thirdHighestValue;
        int productOfLowestTwoAndHighest = highestValue * lowestValue * secondLowestValue;

        return Math.max(productOfHighestThree, productOfLowestTwoAndHighest);
    }
}

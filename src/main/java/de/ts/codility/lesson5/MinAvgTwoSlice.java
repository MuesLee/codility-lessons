package de.ts.codility.lesson5;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 * <p>
 * A non-empty array A consisting of N integers is given.
 * A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements).
 * The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
 * To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p>
 * Write a function:
 * that, given a non-empty array A consisting of N integers,
 * returns the starting position of the slice with the minimal average.
 * <p>
 * If there is more than one slice with a minimal average,
 * you should return the smallest starting position of such a slice.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * <p>
 * Complexity: O(n)
 * Complexity: O(n)
 */
public class MinAvgTwoSlice {

    /**
     * The lowest average can either be a pair or a triplet.
     * All bigger sets can be reduced to size 2 or 3.
     *
     * @param array given array
     * @return first start index of slice with lowest average.
     */
    public int solution(int[] array) {

        double minAvg = 10000;
        int lowestIndex = 0;

        for (int i = 0; i < array.length - 2; i++) {
            float sumOfPair = array[i] + array[i + 1];
            float sumOfTriplet = array[i] + array[i + 1] + array[i + 2];

            float avgOfPair = sumOfPair / 2;
            float avgOfTriplet = sumOfTriplet / 3;

            float minAvgOfThisPairing = Math.min(avgOfPair, avgOfTriplet);
            if (minAvgOfThisPairing < minAvg) {
                minAvg = minAvgOfThisPairing;
                lowestIndex = i;
            }
        }

        float sumOfLastPair = (array[array.length - 2] + array[array.length - 1]);
        float avgOfLastPair = sumOfLastPair / 2;

        if (avgOfLastPair < minAvg) {
            lowestIndex = array.length - 2;
        }

        return lowestIndex;
    }
}

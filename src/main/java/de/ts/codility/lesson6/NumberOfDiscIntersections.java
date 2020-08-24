package de.ts.codility.lesson6;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
 * <p>
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1.
 * An array A of N non-negative integers, specifying the radiuses of the discs, is given.
 * The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * <p>
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th disc
 * have at least one common point (assuming that the discs contain their borders).
 * <p>
 * The figure below shows discs drawn for N = 6 and A as follows:
 * <p>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 2
 * A[3] = 1
 * A[4] = 4
 * A[5] = 0
 * <p>
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * <p>
 * discs 1 and 4 intersect, and both intersect with all the other discs;
 * disc 2 also intersects with discs 0 and 3.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A describing N discs as explained above,
 * returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
 * <p>
 * Given array A shown above, the function should return 11, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class NumberOfDiscIntersections {

    public int solution(int[] disc) {

        long[] discStarts = new long[disc.length];
        long[] discEnds = new long[disc.length];

        for (int i = 0; i < disc.length; i++) {
            discStarts[i] = i - (long) disc[i];
            discEnds[i] = i + (long) disc[i];

        }

        Arrays.sort(discStarts);
        Arrays.sort(discEnds);

        int distinctIntersectionCount = 0;

        for (int closedDiscCount = 0, activeDiscCount = 0; closedDiscCount < discEnds.length; closedDiscCount++) {
            for (; activeDiscCount < discStarts.length && discStarts[activeDiscCount] <= discEnds[closedDiscCount]; activeDiscCount++) {
                distinctIntersectionCount += activeDiscCount - closedDiscCount;
            }
        }

        if (distinctIntersectionCount > 10_000_000)
            return -1;

        return distinctIntersectionCount;
    }
}

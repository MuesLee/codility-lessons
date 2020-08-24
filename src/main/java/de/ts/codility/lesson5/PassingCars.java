package de.ts.codility.lesson5;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 * <p>
 * A non-empty array A consisting of N integers is given.
 * The consecutive elements of array A represent consecutive cars on a road.
 * <p>
 * Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N,
 * is passing when P is traveling to the east and Q is traveling to the west.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p>
 * Write a function:
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * <p>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class PassingCars {

    private static final int RESULT_LIMIT = 1000000000;

    public int solution(int[] road) {

        int carsHeadingEastCount = 0;
        int passingCarCount = 0;

        for (int car : road) {
            if (car == 0) {
                carsHeadingEastCount++;
            } else {
                if (passingCarCount + carsHeadingEastCount > RESULT_LIMIT) {
                    return -1;
                }
                passingCarCount += carsHeadingEastCount;
            }
        }

        return passingCarCount;
    }
}

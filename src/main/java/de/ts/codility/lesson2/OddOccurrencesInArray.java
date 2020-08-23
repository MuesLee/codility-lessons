package de.ts.codility.lesson2;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * A non-empty array A consisting of N integers is given.
 * The array contains an odd number of elements, and each element of the array can be paired with another element
 * that has the same value, except for one element that is left unpaired.
 * <p>
 * Write a function:
 * that, given an array A consisting of N integers fulfilling the above conditions,
 * returns the value of the unpaired element.
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(1)
 */
public class OddOccurrencesInArray {

    /**
     * Finds the one number which appears odd-times in the given array.
     * <p>
     * Uses an XOR bit comparison to figure out which number appears oddly-times.
     * All even-times appearing numbers are evenly added and removed.
     * The active bits after iterating the whole array represent the oddly-times appearing number.
     *
     * @param oddArray odd-sized array containing each but one number an even amount of times
     * @return the single oddly appearing number
     */
    public int solution(int[] oddArray) {

        int bitmap = 0;
        for (int number : oddArray) {
            bitmap = bitmap ^ number;
        }

        return bitmap;
    }
}

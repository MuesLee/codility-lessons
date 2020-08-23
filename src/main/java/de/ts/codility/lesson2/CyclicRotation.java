package de.ts.codility.lesson2;

/**
 * An array A consisting of N integers is given.
 * Rotation of the array means that each element is shifted right by one index,
 * and the last element of the array is moved to the first place.
 * <p>
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Write a function:
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class CyclicRotation {

    public int[] solution(int[] array, int rotateRightCount) {
        if (rotateRightCount == 0 || array.length == 0 || rotateRightCount % array.length == 0) {
            return array;
        }

        int[] rotatedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int indexAfterRotation = (i + rotateRightCount) % array.length;

            rotatedArray[indexAfterRotation] = array[i];
        }

        return rotatedArray;
    }
}

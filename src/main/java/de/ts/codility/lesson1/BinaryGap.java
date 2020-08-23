package de.ts.codility.lesson1;

/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 * <p>
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros
 * that is surrounded by ones at both ends in the binary representation of N.
 * <p>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
 * The number 20 has binary representation 10100 and contains one binary gap of length 1.
 * The number 15 has binary representation 1111 and has no binary gaps.
 * The number 32 has binary representation 100000 and has no binary gaps.
 * <p>
 * Write a function:
 * that, given a positive integer N, returns the length of its longest binary gap.
 * The function should return 0 if N doesn't contain a binary gap.
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class BinaryGap {

    public int findLongestGap(int n) {

        int maxDistance = 0;
        int currentDistance = 0;
        boolean inGap = false;

        char[] binaryRepresentation = Integer.toBinaryString(n).toCharArray();

        for (char binary : binaryRepresentation) {
            if (binary == '1') {
                if (!inGap) {
                    inGap = true;
                } else {
                    maxDistance = Math.max(currentDistance, maxDistance);
                    currentDistance = 0;
                }
            } else if (binary == '0') {
                if (inGap) {
                    currentDistance++;
                }
            }
        }

        return maxDistance;
    }
}

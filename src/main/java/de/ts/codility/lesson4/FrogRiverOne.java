package de.ts.codility.lesson4;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 * <p>
 * A small frog wants to get to the other side of a river.
 * The frog is initially located on one bank of the river (position 0) and wants to get to
 * the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
 * <p>
 * You are given an array A consisting of N integers representing the falling leaves.
 * A[K] represents the position where one leaf falls at time K, measured in seconds.
 * <p>
 * The goal is to find the earliest time when the frog can jump to the other side of the river.
 * The frog can cross only when leaves appear at every position across the river from 1 to X
 * (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves).
 * You may assume that the speed of the current in the river is negligibly small,
 * i.e. the leaves do not change their positions once they fall in the river.
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(x)
 */
public class FrogRiverOne {

    public int solution(long indexOfLastLeaveBeforeRiverBank, int[] leaveArrivalsInSeconds) {

        Set<Integer> indexesWithLeaves = new HashSet<>();
        long sumOfAllNeededIndexesToCrossRiver = ((indexOfLastLeaveBeforeRiverBank + 1) * indexOfLastLeaveBeforeRiverBank) / 2;
        long currentSumOfAllIndexes = 0;

        for (int i = 0; i < leaveArrivalsInSeconds.length; i++) {

            int leaveDropIndex = leaveArrivalsInSeconds[i];

            if (leaveDropIndex <= indexOfLastLeaveBeforeRiverBank && !indexesWithLeaves.contains(leaveDropIndex)) {
                indexesWithLeaves.add(leaveDropIndex);
                currentSumOfAllIndexes += leaveDropIndex;
            }
            if (currentSumOfAllIndexes == sumOfAllNeededIndexesToCrossRiver) {
                return i;
            }
        }

        return -1;
    }
}

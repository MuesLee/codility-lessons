package de.ts.codility.lesson7;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 * You are going to build a stone wall. The wall should be straight and N meters long,
 * and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular).
 * Your task is to compute the minimum number of blocks needed to build the wall.
 * <p>
 * Write a function:
 * that, given an array H of N positive integers specifying the height of the wall,
 * returns the minimum number of blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * <p>
 * H[0] = 8    H[1] = 8    H[2] = 5
 * H[3] = 7    H[4] = 9    H[5] = 8
 * H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class StoneWall {

    public int solution(int[] wallHeights) {

        int neededBlocks = 0;


        Stack<Integer> placedBlocks = new Stack<>();

        placedBlocks.add(wallHeights[0]);
        neededBlocks++;

        for (int i = 1, wallHeightsLength = wallHeights.length; i < wallHeightsLength; i++) {
            int wallHeight = wallHeights[i];

            int currentHeight = placedBlocks.peek();

            if (currentHeight == wallHeight) {
                continue;
            }

            if (currentHeight < wallHeight) {
                placedBlocks.add(wallHeight);
                neededBlocks++;
                continue;
            }


            placedBlocks.pop();
            while (!placedBlocks.isEmpty()) {
                currentHeight = placedBlocks.peek();
                if (currentHeight == wallHeight) {
                    break;
                }
                if (currentHeight < wallHeight) {
                    placedBlocks.add(wallHeight);
                    neededBlocks++;
                } else {
                    placedBlocks.pop();
                }

            }

            if (placedBlocks.isEmpty() && currentHeight != wallHeight) {
                neededBlocks++;
                placedBlocks.add(wallHeight);
            }
        }

        return neededBlocks;
    }
}

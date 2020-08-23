package de.ts.codility.lesson2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CyclicRotationTest {

    private final CyclicRotation classUnderTest = new CyclicRotation();

    private static Stream<Arguments> puzzle() {
        return Stream.of(
                Arguments.of(new int[]{}, 3, new int[]{}),
                Arguments.of(new int[]{1, 2, 3, 4}, 0, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4}, 8, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4}, 1, new int[]{4, 1, 2, 3}),
                Arguments.of(new int[]{1, 2, 3}, 2, new int[]{2, 3, 1}),
                Arguments.of(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8})
        );
    }

    @ParameterizedTest
    @MethodSource("puzzle")
    void solution(int[] givenArray, int givenRotationCount, int[] expectedRotatedArray) {

        int[] actualRotatedArray = classUnderTest.solution(givenArray, givenRotationCount);

        Assertions.assertThat(actualRotatedArray).isEqualTo(expectedRotatedArray);
    }
}

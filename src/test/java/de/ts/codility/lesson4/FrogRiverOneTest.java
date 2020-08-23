package de.ts.codility.lesson4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;


class FrogRiverOneTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 6),
                Arguments.of(5, new int[]{1, 3, 1, 4, 2, 3, 4, 5}, 7),
                Arguments.of(3, new int[]{1, 3, 1, 4, 2, 3, 4, 5}, 4),
                Arguments.of(1, new int[]{1, 3, 1, 4, 2, 3, 4, 5}, 0),
                Arguments.of(2, new int[]{2, 2, 2, 2, 2}, -1),
                Arguments.of(2, new int[]{1}, -1),
                Arguments.of(4, new int[]{1, 2, 3, 4}, 3),
                Arguments.of(100000, IntStream.rangeClosed(1, 100000).toArray(), 99999)

        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testFrogRiverOne(int givenDistance, int[] givenArray, int expectedEarliestTimeInSeconds) {
        FrogRiverOne classUnderTest = new FrogRiverOne();

        int actualTimeInSeconds = classUnderTest.solution(givenDistance, givenArray);

        Assertions.assertThat(actualTimeInSeconds).isEqualTo(expectedEarliestTimeInSeconds);
    }

}

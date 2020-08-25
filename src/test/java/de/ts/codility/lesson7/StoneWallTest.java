package de.ts.codility.lesson7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StoneWallTest {
    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{2}, 1),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{2, 1}, 2),
                Arguments.of(new int[]{6, 7, 6, 1, 6}, 4),
                Arguments.of(new int[]{1, 2, 4, 5, 6, 4, 7, 8, 8, 7, 1, 7}, 8),
                Arguments.of(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}, 7),
                Arguments.of(IntStream.rangeClosed(1, 100_000).map(i -> i * 10000).toArray(), 100_000),
                Arguments.of(IntStream.rangeClosed(1, 100_000).map(i -> 100_101 - i).toArray(), 100_000)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testStoneWall(int[] given, int expected) {
        StoneWall classUnderTest = new StoneWall();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

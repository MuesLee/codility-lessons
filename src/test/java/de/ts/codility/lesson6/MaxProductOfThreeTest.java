package de.ts.codility.lesson6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProductOfThreeTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 3}, 3),
                Arguments.of(new int[]{1, 1, 3, 6}, 18),
                Arguments.of(new int[]{-3, 1, 2, -2, 5, 6}, 60),
                Arguments.of(new int[]{-1, -2, -3, 2, 2, 3}, 18),
                Arguments.of(new int[]{-1000, -2, -1000, 2, 0, 1000}, 1000000000),
                Arguments.of(new int[]{-1000, -1000, -1000}, -1000000000),
                Arguments.of(new int[]{1000, 1000, 1000}, 1000000000),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> 1).toArray(), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testMaxProductOfThree(int[] given, int expected) {
        MaxProductOfThree classUnderTest = new MaxProductOfThree();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }
}

package de.ts.codility.lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinAvgTwoSliceTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 2, 5, 1, 5, 8}, 1),
                Arguments.of(new int[]{1, 2}, 0),
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{2, 2, 0, 0}, 2),
                Arguments.of(new int[]{-3, -5, -8, -4, -10}, 2),
                Arguments.of(new int[]{1000, -1000, 1000, -999, -999}, 3),
                Arguments.of(new int[]{2, 2, 0, 0, -1, 1, 2, -1, 0}, 3),
                Arguments.of(new int[]{-10000, 0, 10000}, 0),
                Arguments.of(new int[]{0, 10000, -9999, -9999, -9999, -10000}, 4),
                Arguments.of(IntStream.rangeClosed(1, 100000).toArray(), 0),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> -1).toArray(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testMinAvgTwoSlice(int[] given, int expected) {
        MinAvgTwoSlice classUnderTest = new MinAvgTwoSlice();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

package de.ts.codility.lesson6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{10, 2, 5, 1, 8, 20}, 1),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{1, 2}, 0),
                Arguments.of(new int[]{1, 1, 1}, 1),
                Arguments.of(new int[]{1, 2, 3}, 0),
                Arguments.of(new int[]{3, 2, 1}, 0),
                Arguments.of(new int[]{2, 9, 10}, 1),
                Arguments.of(new int[]{10, 9, 2, 1, 3}, 1),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> Integer.MAX_VALUE).toArray(), 1),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> Integer.MIN_VALUE).toArray(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testTriangle(int[] given, int expected) {
        Triangle classUnderTest = new Triangle();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

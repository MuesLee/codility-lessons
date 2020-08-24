package de.ts.codility.lesson6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfDiscIntersectionsTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 0, 2}, 3),
                Arguments.of(new int[]{1, 1, 1}, 3),
                Arguments.of(new int[]{1, 5, 2, 1, 4, 0}, 11),
                Arguments.of(IntStream.rangeClosed(1, 10).map(i -> Integer.MAX_VALUE).toArray(), 45),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> Integer.MAX_VALUE).toArray(), -1)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testNumberOfDiscIntersections(int[] given, int expected) {
        NumberOfDiscIntersections classUnderTest = new NumberOfDiscIntersections();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

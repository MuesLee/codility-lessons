package de.ts.codility.lesson6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DistinctTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{0}, 1),
                Arguments.of(new int[]{-1000000, 1000000}, 2),
                Arguments.of(new int[]{2, 1, 1, 2, 3, 1}, 3),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> i * 10).toArray(), 100000)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testDistinct(int[] given, int expected) {
        Distinct classUnderTest = new Distinct();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

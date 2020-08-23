package de.ts.codility.lesson3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TapeEquilibriumTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2, 4, 3}, 1),
                Arguments.of(new int[]{-1000, 1000}, 2000),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> 1).toArray(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testTapeEquilibrium(int[] given, int expected) {
        TapeEquilibrium classUnderTest = new TapeEquilibrium();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

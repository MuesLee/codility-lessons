package de.ts.codility.lesson1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinaryGapTest {

    private final BinaryGap classUnderTest = new BinaryGap();

    private static Stream<Arguments> puzzles() {

        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(0, 0),
                Arguments.of(529, 4),
                Arguments.of(1162, 3),
                Arguments.of(805306373, 25),
                Arguments.of(5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("puzzles")
    void solution(int number, int expectedLongestBinaryGap) {

        int actualLongestBinaryGap = classUnderTest.findLongestGap(number);

        Assertions.assertThat(actualLongestBinaryGap).isEqualTo(expectedLongestBinaryGap);
    }
}

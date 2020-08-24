package de.ts.codility.lesson4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MissingIntegerTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5),
                Arguments.of(new int[]{-1, 2}, 1),
                Arguments.of(new int[]{-1, -2}, 1),
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(IntStream.rangeClosed(2, 1000000).toArray(), 1),
                Arguments.of(IntStream.rangeClosed(1, 1000000).toArray(), 1000001)
        );
    }

    @ParameterizedTest(name = "{index}: Smallest missing number should be {1}")
    @MethodSource("arguments")
    void testMissingInteger(int[] givenArray, int expectedSmallestMissingPositiveNumber) {
        MissingInteger classUnderTest = new MissingInteger();

        int actual = classUnderTest.solution(givenArray);

        assertThat(actual).isEqualTo(expectedSmallestMissingPositiveNumber);
    }

}

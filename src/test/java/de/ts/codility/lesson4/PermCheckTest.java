package de.ts.codility.lesson4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PermCheckTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 1}, 0),
                Arguments.of(new int[]{2}, 0),
                Arguments.of(new int[]{1, 2, 3, 4}, 1),
                Arguments.of(new int[]{1, 2, 4}, 0),
                Arguments.of(new int[]{1, 2, 2, 3, 4}, 0),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> i * 1000).toArray(), 0)
        );
    }

    @ParameterizedTest(name = "{index}: ")
    @MethodSource("arguments")
    void testPermCheck(int[] given, int expected) {
        PermCheck classUnderTest = new PermCheck();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

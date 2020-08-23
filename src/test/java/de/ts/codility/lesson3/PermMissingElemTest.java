package de.ts.codility.lesson3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PermMissingElemTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 5}, 4),
                Arguments.of(new int[]{1, 2, 3, 4}, 5),
                Arguments.of(new int[]{}, 1),
                Arguments.of(IntStream.rangeClosed(1, 100000).toArray(), 100001),
                Arguments.of(IntStream.rangeClosed(2, 100000).toArray(), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testPermMissingElem(int[] givenArray, int expected) {
        PermMissingElem classUnderTest = new PermMissingElem();

        int actual = classUnderTest.solution(givenArray);

        assertThat(actual).isEqualTo(expected);
    }

}

package de.ts.codility.lesson3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FrogJmpTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, 1, 30, 0),
                Arguments.of(1, 31, 30, 1),
                Arguments.of(1, 4, 2, 2),
                Arguments.of(1, 61, 29, 3),
                Arguments.of(10, 85, 30, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testFrogJmp(int givenStart, int givenEnd, int givenJumpRange, int expectedFrogJmpCount) {
        FrogJmp classUnderTest = new FrogJmp();

        int actualJmpCount = classUnderTest.solution(givenStart, givenEnd, givenJumpRange);

        assertThat(actualJmpCount).isEqualTo(expectedFrogJmpCount);
    }

}

package de.ts.codility.lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountDivTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(0, 0, 1, 1),
                Arguments.of(0, 0, 2000000000, 1),
                Arguments.of(1, 1, 1, 1),
                Arguments.of(1, 1, 11, 0),
                Arguments.of(1, 11, 11, 1),
                Arguments.of(10, 10, 7, 0),
                Arguments.of(10, 10, 2, 1),
                Arguments.of(10, 14, 7, 1),
                Arguments.of(2000000000, 2000000000, 1, 1),
                Arguments.of(2000000000, 2000000000, 2000000000, 1),
                Arguments.of(6, 11, 2, 3),
                Arguments.of(0, 2000000000, 1, 2000000001),
                Arguments.of(0, 2000000000, 2, 1000000001),
                Arguments.of(1, 2000000000, 1, 2000000000),
                Arguments.of(1, 2000000000, 2, 1000000000)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testCountDiv(int givenA, int givenB, int givenK, int expected) {
        CountDiv classUnderTest = new CountDiv();

        int actual = classUnderTest.solution(givenA, givenB, givenK);

        assertThat(actual).isEqualTo(expected);
    }

}

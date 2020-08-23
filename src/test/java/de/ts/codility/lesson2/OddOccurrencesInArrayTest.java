package de.ts.codility.lesson2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OddOccurrencesInArrayTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 3, 2, 1}, 4),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{2, 2, 45}, 45),
                Arguments.of(new int[]{3, 21, 3}, 21),
                Arguments.of(new int[]{3, 3, 4, 4, 1, 1, 5}, 5),
                Arguments.of(new int[]{5, 3, 3, 4, 4, 1, 1}, 5),
                Arguments.of(new int[]{5, 1, 1, 4, 4, 1, 1}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testOddOccurrencesInArray(int[] givenArray, int expectedOddNumber) {
        OddOccurrencesInArray classUnderTest = new OddOccurrencesInArray();

        int actual = classUnderTest.solution(givenArray);

        assertThat(actual).isEqualTo(expectedOddNumber);
    }

}

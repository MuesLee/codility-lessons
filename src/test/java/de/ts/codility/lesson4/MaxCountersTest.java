package de.ts.codility.lesson4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class MaxCountersTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(5, new int[]{3, 4, 4, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2}),
                Arguments.of(3, new int[]{1, 1, 1, 4}, new int[]{3, 3, 3}),
                Arguments.of(3, new int[]{4, 1, 1, 1}, new int[]{3, 0, 0}),
                Arguments.of(100000, IntStream.rangeClosed(1, 100000).toArray(), IntStream.rangeClosed(1, 100000).map(i -> 1).toArray()),
                Arguments.of(3, new int[]{1, 4, 1, 1}, new int[]{3, 1, 1}),
                Arguments.of(1, new int[]{1}, new int[]{1})

        );
    }

    @ParameterizedTest(name = "{index}: N = {0} ")
    @MethodSource("arguments")
    void testMaxCounters(int slotCount, int[] givenOperations, int[] expectedArray) {
        MaxCounters classUnderTest = new MaxCounters();

        int[] actual = classUnderTest.solution(slotCount, givenOperations);

        Assertions.assertThat(actual).isEqualTo(expectedArray);
    }
}

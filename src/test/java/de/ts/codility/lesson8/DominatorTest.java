package de.ts.codility.lesson8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DominatorTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{0}, new int[]{0}, 0),
                Arguments.of(new int[]{1, 2}, new int[]{-1}, -1),
                Arguments.of(new int[]{1, 1}, new int[]{0, 1}, 1),
                Arguments.of(new int[]{1, 1, 2}, new int[]{0, 1}, 1),
                Arguments.of(new int[]{3, 4, 3, 2, 3, -1, 3, 3}, new int[]{0, 2, 4, 6, 7}, 3),
                Arguments.of(new int[]{3, 4, 3, 2, 4, 5, 5, 5, 5, 5, 5, 5, 5, 3, -1, 3, 3}, new int[]{-1}, -1),
                Arguments.of(IntStream.rangeClosed(1, 100_000).toArray(), new int[]{-1}, -1),
                Arguments.of(IntStream.rangeClosed(1, 100_000).map(i -> Integer.MAX_VALUE).toArray(), IntStream.rangeClosed(0, 99_999).toArray(), Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testDominator(int[] given, int[] dominatorIndexes, int dominator) {
        Dominator classUnderTest = new Dominator();

        int actualIndex = classUnderTest.solution(given);

        assertThat(dominatorIndexes).as("The actual dominator is " + dominator + ", so the result should be any of dominator's indexes: " + Arrays.toString(dominatorIndexes)).contains(actualIndex);
    }

}

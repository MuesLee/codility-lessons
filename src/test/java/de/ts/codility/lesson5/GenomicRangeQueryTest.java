package de.ts.codility.lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GenomicRangeQueryTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("A", new int[]{0}, new int[]{0}, new int[]{1}),
                Arguments.of("C", new int[]{0}, new int[]{0}, new int[]{2}),
                Arguments.of("G", new int[]{0}, new int[]{0}, new int[]{3}),
                Arguments.of("T", new int[]{0}, new int[]{0}, new int[]{4}),
                Arguments.of("GT", new int[]{0, 0, 1}, new int[]{0, 1, 1}, new int[]{3, 3, 4}),
                Arguments.of("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{2, 4, 1}),
                Arguments.of("ACGT", new int[]{0, 1, 2, 3}, new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 4}),
                Arguments.of("TGCA", new int[]{0, 1, 2, 3}, new int[]{0, 1, 2, 3}, new int[]{4, 3, 2, 1}),
                Arguments.of(IntStream.rangeClosed(1, 1000000).boxed().map(i -> "A").collect(Collectors.joining()),
                        IntStream.rangeClosed(1, 50000).toArray(),
                        IntStream.rangeClosed(1, 50000).map(i -> 1000000 - 1).toArray(),
                        IntStream.rangeClosed(1, 50000).map(i -> 1).toArray()),
                Arguments.of(IntStream.rangeClosed(1, 1000000).boxed().map(i -> "T").collect(Collectors.joining()),
                        IntStream.rangeClosed(1, 50000).toArray(),
                        IntStream.rangeClosed(1, 50000).map(i -> 1000000 - 1).toArray(),
                        IntStream.rangeClosed(1, 50000).map(i -> 4).toArray())
        );
    }

    @ParameterizedTest(name = "{index}: ")
    @MethodSource("arguments")
    void testGenomicRangeQuery(String givenS, int[] givenP, int[] givenQ, int[] expected) {
        GenomicRangeQuery classUnderTest = new GenomicRangeQuery();

        int[] actual = classUnderTest.solution(givenS, givenP, givenQ);

        assertThat(actual).isEqualTo(expected);
    }

}

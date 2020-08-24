package de.ts.codility.lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PassingCarsTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 1, 1}, 5),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{0, 1}, 1),
                Arguments.of(new int[]{1, 0}, 0),
                Arguments.of(new int[]{1, 0, 1, 1}, 2),
                Arguments.of(new int[]{1, 0, 1, 1, 0}, 2),
                Arguments.of(new int[]{1, 0, 1, 1, 0, 1}, 4),
                Arguments.of(new int[]{1, 0, 1, 1, 0, 1, 1}, 6),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(i -> 1).toArray(), 0),
                Arguments.of(Stream.of(
                        IntStream.rangeClosed(1, 50000).map(i -> 0).toArray(),
                        IntStream.rangeClosed(1, 50000).map(i -> 1).toArray())
                        .flatMapToInt(Arrays::stream).toArray(), -1),
                Arguments.of(Stream.of(
                        IntStream.rangeClosed(1, 25000).map(i -> 0).toArray(),
                        IntStream.rangeClosed(1, 40000).map(i -> 1).toArray())
                        .flatMapToInt(Arrays::stream).toArray(), 1000000000),
                Arguments.of(Stream.of(
                        IntStream.rangeClosed(1, 25000).map(i -> 0).toArray(),
                        IntStream.rangeClosed(1, 40001).map(i -> 1).toArray())
                        .flatMapToInt(Arrays::stream).toArray(), -1)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testPassingCars(int[] given, int expected) {
        PassingCars classUnderTest = new PassingCars();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

package de.ts.codility.lesson7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FishTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{0}, new int[]{0}, 1),
                Arguments.of(new int[]{1}, new int[]{1}, 1),
                Arguments.of(new int[]{1, 0}, new int[]{1, 0}, 1),
                Arguments.of(new int[]{0, 1}, new int[]{1, 0}, 1),
                Arguments.of(new int[]{0, 1}, new int[]{0, 1}, 2),
                Arguments.of(new int[]{0, 1, 2}, new int[]{1, 0, 1}, 2),
                Arguments.of(new int[]{1, 0, 2, 1_000_000_000, 9}, new int[]{1, 0, 1, 0, 1}, 2),
                Arguments.of(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}, 2),
                Arguments.of(IntStream.rangeClosed(1, 100_000).toArray(), IntStream.rangeClosed(1, 100_000).map(i -> 1).toArray(), 100_000),
                Arguments.of(IntStream.rangeClosed(1, 100_000).toArray(), IntStream.rangeClosed(1, 100_000).map(i -> 0).toArray(), 100_000),
                Arguments.of(
                        IntStream.rangeClosed(1, 100_000).toArray(),
                        Stream.of(IntStream.rangeClosed(1, 50_000).map(i -> 1).toArray(), IntStream.rangeClosed(50_001, 100_000).map(i -> 0).toArray()).flatMapToInt(Arrays::stream).toArray()
                        , 50_000),
                Arguments.of(
                        Stream.of(new int[]{100_000}, IntStream.rangeClosed(1, 99_999).toArray()).flatMapToInt(Arrays::stream).toArray(),
                        Stream.of(new int[]{1}, IntStream.rangeClosed(1, 99_999).map(i -> 0).toArray()).flatMapToInt(Arrays::stream).toArray()
                        , 1),
                Arguments.of(
                        Stream.of(new int[]{1, 100_000}, IntStream.rangeClosed(2, 99_999).toArray()).flatMapToInt(Arrays::stream).toArray(),
                        Stream.of(new int[]{1, 1}, IntStream.rangeClosed(1, 99_998).map(i -> 0).toArray()).flatMapToInt(Arrays::stream).toArray()
                        , 2),
                Arguments.of(
                        Stream.of(IntStream.rangeClosed(1, 99_999).toArray(), new int[]{100_000}).flatMapToInt(Arrays::stream).toArray(),
                        Stream.of(IntStream.rangeClosed(1, 99_999).map(i -> 1).toArray(), new int[]{0}).flatMapToInt(Arrays::stream).toArray()
                        , 1),
                Arguments.of(
                        Stream.of(IntStream.rangeClosed(2, 99_999).toArray(), new int[]{100_000, 1}).flatMapToInt(Arrays::stream).toArray(),
                        Stream.of(IntStream.rangeClosed(2, 99_999).map(i -> 1).toArray(), new int[]{0, 0}).flatMapToInt(Arrays::stream).toArray()
                        , 2)

        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testFish(int[] givenFishSizes, int[] givenFishDirection, int expectedLivingFish) {
        Fish classUnderTest = new Fish();

        int actual = classUnderTest.solution(givenFishSizes, givenFishDirection);

        assertThat(actual).isEqualTo(expectedLivingFish);
    }

}

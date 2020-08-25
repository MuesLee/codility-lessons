package de.ts.codility.lesson7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BracketsTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("", 1),
                Arguments.of(" ", 0),
                Arguments.of(" ( ) ", 1),
                Arguments.of("A", 0),
                Arguments.of("(A", 0),
                Arguments.of("[A", 0),
                Arguments.of("{A", 0),
                Arguments.of("A)", 0),
                Arguments.of("A]", 0),
                Arguments.of("A}", 0),
                Arguments.of("(", 0),
                Arguments.of(")", 0),
                Arguments.of("()", 1),
                Arguments.of("[", 0),
                Arguments.of("]", 0),
                Arguments.of("[]", 1),
                Arguments.of("{", 0),
                Arguments.of("}", 0),
                Arguments.of("{}", 1),
                Arguments.of("(}", 0),
                Arguments.of("(]", 0),
                Arguments.of("{]", 0),
                Arguments.of("[)", 0),
                Arguments.of("[}", 0),
                Arguments.of("{[()()]}", 1),
                Arguments.of("([)()]", 0),
                Arguments.of("([{)]}", 0),
                Arguments.of(Stream.of(
                        IntStream.rangeClosed(1, 100000).boxed().map(i -> "(").collect(Collectors.toList()),
                        IntStream.rangeClosed(1, 100000).boxed().map(i -> ")").collect(Collectors.toList())
                ).flatMap(Collection::stream).collect(Collectors.joining()), 1)

        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testBrackets(String given, int expected) {
        Brackets classUnderTest = new Brackets();

        int actual = classUnderTest.solution(given);

        assertThat(actual).isEqualTo(expected);
    }

}

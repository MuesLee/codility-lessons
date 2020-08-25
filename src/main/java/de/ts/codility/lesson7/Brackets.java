package de.ts.codility.lesson7;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * <p>
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}",
 * the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class Brackets {

    public int solution(String string) {

        if (string == null || string.isEmpty()) {
            return 1;
        }

        Stack<Character> openBrackets = new Stack<>();

        boolean stringContainsBrackets = false;
        char[] chars = string.toCharArray();

        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                case '[':
                case '{':
                    openBrackets.push(aChar);
                    stringContainsBrackets = true;
                    break;
                case ')':
                    if (bracketCannotBeClosed(openBrackets, '(')) {
                        return 0;
                    }
                    break;
                case '}':
                    if (bracketCannotBeClosed(openBrackets, '{')) {
                        return 0;
                    }
                    break;
                case ']':
                    if (bracketCannotBeClosed(openBrackets, '[')) {
                        return 0;
                    }
            }
        }

        if (openBrackets.size() > 0 || !stringContainsBrackets) {
            return 0;
        }

        return 1;
    }

    private boolean bracketCannotBeClosed(Stack<Character> openBrackets, char bracket) {
        return openBrackets.isEmpty() || openBrackets.pop() != bracket;
    }

}

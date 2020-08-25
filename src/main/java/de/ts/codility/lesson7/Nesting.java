package de.ts.codility.lesson7;


import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 * <p>
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * Write a function:
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 * <p>
 * Complexity time: O(n)
 * Complexity space: O(n)
 */
public class Nesting {

    public int solution(String string) {

        if (string.isEmpty()) {
            return 1;
        }

        Stack<Character> openBrackets = new Stack<>();
        boolean stringContainsBrackets = false;


        char[] chars = string.toCharArray();
        for (char character : chars) {
            if (character == '(') {
                stringContainsBrackets = true;
                openBrackets.add(character);
            } else if (character == ')') {
                if (openBrackets.isEmpty() || openBrackets.peek() != '(') {
                    return 0;
                } else {
                    openBrackets.pop();
                }
            }
        }

        return openBrackets.isEmpty() && stringContainsBrackets ? 1 : 0;
    }
}

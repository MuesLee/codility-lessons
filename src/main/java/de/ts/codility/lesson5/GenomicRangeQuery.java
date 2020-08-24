package de.ts.codility.lesson5;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * <p>
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T,
 * which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor,
 * which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
 * You are going to answer several queries of the form:
 * What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 * <p>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
 * There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
 * The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides
 * contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 * <p>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 * <p>
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice),
 * whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides,
 * in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers,
 * returns an array consisting of M integers specifying the consecutive answers to all queries.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 * <p>
 * Complexity time: O(n + m)
 * Complexity space: O(n)
 */
public class GenomicRangeQuery {

    public int[] solution(String nucleotides, int[] queryStarts, int[] queryEnds) {

        int[] queryResults = new int[queryStarts.length];
        char[] chars = nucleotides.toCharArray();
        int length = chars.length;

        int[] rangeCountA = new int[length + 1];
        int[] rangeCountC = new int[length + 1];
        int[] rangeCountG = new int[length + 1];
        // don't need to track T. It must be T, if it is not A, C or G.

        for (int i = 0; i < length; i++) {
            char nucleotide = chars[i];

            switch (nucleotide) {
                case 'A':
                    rangeCountA[i + 1] = rangeCountA[i] + 1;
                    rangeCountC[i + 1] = rangeCountC[i];
                    rangeCountG[i + 1] = rangeCountG[i];
                    break;
                case 'C':
                    rangeCountA[i + 1] = rangeCountA[i];
                    rangeCountC[i + 1] = rangeCountC[i] + 1;
                    rangeCountG[i + 1] = rangeCountG[i];
                    break;
                case 'G':
                    rangeCountA[i + 1] = rangeCountA[i];
                    rangeCountC[i + 1] = rangeCountC[i];
                    rangeCountG[i + 1] = rangeCountG[i] + 1;
                    break;
                case 'T':
                    rangeCountA[i + 1] = rangeCountA[i];
                    rangeCountC[i + 1] = rangeCountC[i];
                    rangeCountG[i + 1] = rangeCountG[i];
                    break;
            }


        }

        for (int queryIndex = 0; queryIndex < queryStarts.length; queryIndex++) {
            int queryStart = queryStarts[queryIndex];
            int queryEnd = queryEnds[queryIndex];

            boolean hasAinRange = rangeCountA[queryEnd + 1] - rangeCountA[queryStart] > 0;
            boolean hasCinRange = rangeCountC[queryEnd + 1] - rangeCountC[queryStart] > 0;
            boolean hasGinRange = rangeCountG[queryEnd + 1] - rangeCountG[queryStart] > 0;

            if (hasAinRange) {
                queryResults[queryIndex] = 1;
            } else if (hasCinRange) {
                queryResults[queryIndex] = 2;
            } else if (hasGinRange) {
                queryResults[queryIndex] = 3;
            } else
                queryResults[queryIndex] = 4;
        }

        return queryResults;
    }
}

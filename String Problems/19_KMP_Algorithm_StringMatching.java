// LeetCode Problem: KMP Algorithm for String Matching
// This Java program implements the KMP (Knuth-Morris-Pratt) algorithm for string matching.
// The KMP algorithm efficiently finds all occurrences of a pattern string within a text string.
// It uses a "longest prefix suffix" (LPS) array to efficiently determine the next position to start searching for a match.
// Time Complexity: O(n + m), where n is the length of the text and m is the length of the pattern.
// Space Complexity: O(m) for the LPS array.
// The program returns a list of starting indices where the pattern is found in the text.

import java.util.ArrayList;

class GfG {

    // Helper method to build LPS (Longest Prefix Suffix) array for the pattern
    static void constructLps(String pat, int[] lps) {
        int m = pat.length();
        int len = 0;   // length of previous longest prefix suffix
        lps[0] = 0;    // lps[0] is always 0
        int i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // KMP search: Returns list of all starting indices where pattern is found in text
    static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        if (m > n) return res;

        int[] lps = new int[m];
        constructLps(pat, lps);

        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    // Found a match ending at i-1, starting at i-j
                    res.add(i - j);
                    j = lps[j - 1]; // Continue search for next matches
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    // Test the KMP implementation with a sample input
    
}

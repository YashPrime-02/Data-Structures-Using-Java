// LeetCode Problem: KMP Algorithm for String Matching
// This Java program implements the KMP (Knuth-Morris-Pratt) algorithm for string matching.
// The KMP algorithm efficiently finds all occurrences of a pattern string within a text string.    
// It uses a "longest prefix suffix" (LPS) array to efficiently determine the next position to start searching for a match.
// Time Complexity: O(n + m), where n is the length of the text and m is the length of the pattern.
// Space Complexity: O(m) for the LPS array.
// The program returns a list of starting indices where the pattern is found in the text.
// The LPS array is built to avoid unnecessary comparisons in the text when a mismatch occurs.
import java.util.ArrayList;
import java.util.List;
class Solution {
    
    // Function to build the LPS (Longest Prefix Suffix) array
    // lps[i] = length of the longest prefix of the pattern which is also a suffix ending at i
    private int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // lps[0] is always 0

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {  
                // mismatch after len matches
                if (len != 0) {
                    // try previous longest prefix suffix length
                    len = lps[len - 1];
                } else {
                    // if length == 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    // KMP search that returns all starting indexes of occurrences of pat in txt
    public List<Integer> searchPattern(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        if (m > n) return result; // pattern longer than text => no matches

        int[] lps = buildLPS(pat);

        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    // found a match, add start index to result
                    result.add(i - j);
                    j = lps[j - 1]; // continue searching for next matches
                }
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return result;
    }
    
  
}

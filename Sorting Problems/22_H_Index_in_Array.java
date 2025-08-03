// Java Program to find H-index using Counting Sort
// H-index is defined as the maximum value of h such that the given author has published h papers
// that have at least h citations each.
// This solution uses a counting sort-like approach to efficiently compute the H-index in O(n) time.
// The algorithm counts the number of papers with each citation count and then determines the H-index.
// This approach is efficient and works well for the problem constraints.
// The solution uses O(n) time and O(n) space for the frequency array.

class Solution {
    static int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];

        // Count the frequency of citations
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n)
                freq[n] += 1;
            else
                freq[citations[i]] += 1;
        }

        int idx = n;
        
        // Variable to keep track of the count of papers
        // having at least idx citations
        int s = freq[n]; 
        while (s < idx) {
            idx--;
            s += freq[idx];
        }
        
        // Return the largest index for which the count of 
        // papers with at least idx citations becomes >= idx
        return idx;
    }

}
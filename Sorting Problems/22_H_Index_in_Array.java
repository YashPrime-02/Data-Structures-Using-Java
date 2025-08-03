// Java Program to find H-index using Counting Sort
// H-index is defined as the maximum value of h such that the given author has published h papers
// that have at least h citations each.
// This solution uses a counting sort-like approach to efficiently compute the H-index in O(n) time.
// The algorithm counts the number of papers with each citation count and then determines the H-index.
// This approach is efficient and works well for the problem constraints.
// The solution uses O(n) time and O(n) space for the frequency array.

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n+1]; // freq[i] for papers with i citations (freq[n]: count of papers with citations ≥ n)
        
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n)
                freq[n]++; // citations ≥ n, count in last bucket
            else
                freq[citations[i]]++; // count this exact citation value
        }
        
        int idx = n;
        int sum = freq[n]; // number of papers with at least n citations
        
        // Decrease idx while total papers with ≥ idx citations is still less than idx
        while (sum < idx) {
            idx--;
            sum += freq[idx]; // add in all papers with exactly idx citations
        }
        
        return idx;
    }
}

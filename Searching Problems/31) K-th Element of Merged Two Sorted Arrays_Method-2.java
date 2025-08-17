/*
    Problem: Find the K-th Element from Two Sorted Arrays (Optimal Method)

    You are given:
       - Two sorted arrays a[] and b[]
       - An integer k (1-based index)
    Task:
       - Imagine merging these two sorted arrays into one sorted array.
       - Return the K-th smallest element in that merged array.
       - The arrays can have different lengths.

    Method Used Here (Binary Search on Partition):
       ✅ We don't actually merge (which would be O(n + m)).
       ✅ We choose how many elements to pick from the first array
          using binary search, and the rest come from the second array.
       ✅ We adjust the partition until all elements on the left side 
          are <= all elements on the right side.
       ✅ The answer will be the maximum element from the "left partition".

    Time Complexity:  O(log(min(n, m)))
    Space Complexity: O(1)  (no extra memory except variables)
*/

import java.util.*;

class Solution {

    // Function to find the k-th element
    static int kthElement(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;

        // Always binary search on the smaller array for efficiency
        if (n > m)
            return kthElement(b, a, k);

        // Setting binary search limits:
        // lo = minimum elements we can take from a[]
        // hi = maximum elements we can take from a[]
        int lo = Math.max(0, k - m);
        int hi = Math.min(k, n);

        while (lo <= hi) {
            // mid1 = elements taken from a[]
            int mid1 = (lo + hi) / 2;
            // mid2 = elements taken from b[]
            int mid2 = k - mid1;

            // Values to the left of partition in a[]
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            // Values to the right of partition in a[]
            int r1 = (mid1 == n) ? Integer.MAX_VALUE : a[mid1];

            // Values to the left of partition in b[]
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            // Values to the right of partition in b[]
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : b[mid2];

            // Check if we found a valid partition
            if (l1 <= r2 && l2 <= r1) {
                // The k-th smallest is the bigger of the two "left max" values
                return Math.max(l1, l2);
            }
            // If a's left part has a value too big, move search left
            else if (l1 > r2) {
                hi = mid1 - 1;
            }
            // If a's left part is too small, move search right
            else {
                lo = mid1 + 1;
            }
        }

        return -1; // just as a safeguard; shouldn't happen for valid inputs
    }
}

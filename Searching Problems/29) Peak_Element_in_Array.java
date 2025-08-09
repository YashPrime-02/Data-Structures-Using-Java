/**
 * Problem: Find Peak Element in Array
 * ------------------------------------
 * A peak element in an array is an element that is strictly greater than its neighbors.
 * Given an array, find the index of any one peak element.
 * 
 * Special rules:
 * - The first element is a peak if it is greater than the second element.
 * - The last element is a peak if it is greater than the second-to-last element.
 * 
 * Approach:
 * 1. Check corner cases for first and last elements.
 * 2. Use binary search in the range [1, n-2] to find a mid element
 *    that is greater than its neighbors (peak).
 * 3. Decide search direction:
 *    - If arr[mid] < arr[mid+1], peak lies on the right.
 *    - Otherwise, peak lies on the left.
 * 
 * Time Complexity: O(log N)
 *    - Binary search cuts the range in half each time.
 * Space Complexity: O(1)
 *    - We only use a few extra variables for indices.
 */

class Solution {

    static int peakElement(int[] arr) {
        int n = arr.length;

        // If array has only one element, it's trivially the peak
        if (n == 1)
            return 0;

        // Check if the first element is a peak
        if (arr[0] > arr[1])
            return 0;

        // Check if the last element is a peak
        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        // Set search boundaries for binary search
        int lo = 1, hi = n - 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // Check if the middle element is a peak element
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;

            // If next neighbor is greater, peak exists on right side
            if (arr[mid] < arr[mid + 1])
                lo = mid + 1;

            // Else, peak must be on the left side
            else
                hi = mid - 1;
        }

        // Default return (though by logic, code should find a peak earlier)
        return 0;
    }
}

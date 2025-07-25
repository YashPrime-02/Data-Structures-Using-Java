/**
 * Kadane's Algorithm for Maximum Subarray Sum
 *
 * This algorithm finds the maximum sum of a contiguous subarray within a one-dimensional integer array.
 * It works by iterating through the array and dynamically computing the sum of the current subarray,
 * resetting the sum to zero when it becomes negative (as a negative sum can't contribute to a maximum).
 * The algorithm is optimal for this problem, handling arrays with negative values as well.
 *
 * Time Complexity: O(n)   - Each element is processed once.
 * Space Complexity: O(1)  - Constant space; only a few variables used.
 *
 * Example:
 * Input:  [2, 3, -8, 7, -1, 2, 3]
 * Output: 11  (from subarray [7, -1, 2, 3])
 */
class Solution {
    int maxSubarraySum(int[] arr) {
        int max1 = Integer.MIN_VALUE; // Tracks the maximum subarray sum found so far
        int sum = 0;            // Tracks the sum of the current subarray

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];                // Add current element to current subarray sum
            if (max1 < sum)                          // Update max1 if needed
                max1 = sum;
            if (sum < 0)                                 // Reset current sum if it drops below 0
                sum = 0;
        }
        return max1;
    }
}
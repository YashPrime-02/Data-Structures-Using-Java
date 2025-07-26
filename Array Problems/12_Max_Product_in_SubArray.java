/**
 * Problem: Maximum Product Subarray
 * ----------------------------------
 * Given an integer array arr[], find the contiguous subarray (containing at least one number)
 * which has the largest product, and return its product.
 *
 * Approach (mirrors your C++ code):
 * - Traverse from both left and right, maintaining prefix and suffix products.
 * - Update the answer with the maximum among all prefix/suffix products and handle zeros by resetting to 1.
 * - This handles arrays with negative numbers and zeros efficiently.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    int maxProductSubarray(int[] arr) {
        int n = arr.length;
        int pre = 1;    // Product of prefix subarray
        int suff = 1;   // Product of suffix subarray
        int ans = Integer.MIN_VALUE; // Stores the result

        for (int i = 0; i < n; i++) {
            // If prefix is zero, reset to 1
            pre = (pre == 0 ? 1 : pre) * arr[i];
            // If suffix is zero, reset to 1
            suff = (suff == 0 ? 1 : suff) * arr[n - i - 1];
            // Update answer with current prefix and suffix products
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}

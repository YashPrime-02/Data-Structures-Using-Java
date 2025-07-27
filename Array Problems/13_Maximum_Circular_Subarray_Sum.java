class Solution {
    /**
     * Problem: Maximum Circular Subarray Sum
     * ---------------------------------------
     * Given a circular array, find the maximum sum of a contiguous subarray.
     * This can be solved using Kadane's algorithm for both normal and circular cases.
     *
     * Approach:
     * 1. Use Kadane's algorithm to find the maximum subarray sum in the normal case.
     * 2. Calculate the total sum of the array and negate all elements, then apply Kadane's algorithm again.
     * 3. The result is the maximum of the two cases, ensuring to handle edge cases where all elements are negative.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */ 
    // Helper function to apply Kadane's algorithm
    // to find the maximum subarray sum
    // and return the maximum circular subarray sum4
    // This function is used to handle the circular nature of the array.
    // It calculates the maximum subarray sum in a circular manner.
        int kadanes(int[] arr) {
        int max1 = Integer.MIN_VALUE; // Tracks the maximum subarray sum found so far
        int sum = 0;            // Tracks the sum of the current subarray

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];                // Add current element to current subarray sum
            if (max1 < sum)    
            {                      // Update max1 if needed
                max1 = sum;
            }
            if (sum < 0) {
                sum = 0;
            } // Reset sum to 0 if it becomes negative
        }
        return max1;
    }


    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 0) return 0;
        int x = kadanes(A);
        int y = 0;
        for (int i = 0; i < A.length; i++) {
            y += A[i];
            A[i] = -A[i];
        }
        int z = kadanes(A);
        if (y + z == 0) return x;
        return Math.max(x, y + z);
    }
}

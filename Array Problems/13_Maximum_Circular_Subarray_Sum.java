
/**
 * Problem: Maximum Circular Subarray Sum
 * --------------------------------------
 * Given an integer array arr[], find the maximum sum of a contiguous subarray
 * in a circular manner. This means that the subarray can wrap around the end of the array.
 *
 * Approach:
 * - Use Kadane's algorithm to find the maximum subarray sum in a non-circular manner.
 * - Calculate the total sum of the array and then invert the elements to find the minimum subarray sum.
 * - The maximum circular subarray sum can be derived from the total sum minus the minimum subarray sum.
 * - Handle edge cases where all elements are negative.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
// Java program to find the maximum circular subarray sum
// using Kadane's algorithm
// and the total sum of the array.
// This approach is efficient and handles both positive and negative numbers.
// This code is a direct translation of the C++ logic provided in the context.
// This code is designed to be efficient and concise, following the principles of Kadane's algorithm.
// It uses a single pass to calculate the maximum subarray sum in both circular and non-circular cases,
// ensuring optimal performance with O(n) time complexity and O(1) space complexity.    


class Solution {
    
    // Standard Kadane's algorithm to find the maximum subarray sum (linear, non-circular)
    public int kadanes(int arr[]) {
        int max1 = Integer.MIN_VALUE; // Stores the maximum subarray sum found so far
        int sum = 0;                  // Current running sum of the subarray under consideration

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];            // Add current element to running sum

            // Update max1 if current sum is greater than max1 found so far
            if (max1 < sum) {
                max1 = sum;
            }

            // If running sum becomes negative, reset it to zero
            // because a negative sum won't help in maximizing future sums
            if (sum < 0) {
                sum = 0;
            }
        }
        return max1; // Return the maximum sum found in the array
    }
    
    // Function to find the maximum circular subarray sum
    public int maxCircularSum(int arr[]) {
        if (arr.length == 0) return 0;  // Edge case: empty array

        int x = kadanes(arr);  // Maximum subarray sum in non-circular (linear) case

        int y = 0;             // To store total sum of all elements in the array
        
        // Invert all elements to find minimum subarray sum using Kadane's algorithm trick
        for (int i = 0; i < arr.length; i++) {
            y += arr[i];        // Calculate total sum of array elements
            arr[i] = -arr[i];   // Negate all elements to reuse Kadane's for min subarray
        }

        int z = kadanes(arr);  // Kadane's on negated array to find max subarray sum,
                              // which corresponds to the minimum subarray sum of original array (negated back)

        // If z + y == 0, it means all elements are negative (since total sum == min subarray sum),
        // so we just return x (non-circular max) because circular wrap doesn't help
        if (y + z == 0) return x;

        // Otherwise, maximum circular subarray sum will be:
        // max between non-circular max (x) and circular max (total sum - min subarray sum)
        return Math.max(x, y + z);
    }
}

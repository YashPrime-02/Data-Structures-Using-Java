// LeetCode Problem: Minimize Maximum Distance between towers
// This Java program minimizes the maximum difference between tower heights after modifying each height by at most k.
// It uses a greedy approach with sorting and then checks possible scenarios to find the minimized maximum difference.
// Time Complexity: O(n log n) due to sorting.
// Space Complexity: O(1).

import java.util.Arrays;

class Solution 
{
    int getMinDiff(int[] arr, int k) 
    {
        int n = arr.length;
        
        // Sort the array to allow greedy adjustment of towers
        Arrays.sort(arr);

        // Initial answer: difference between max and min heights without any modification
        int ans = arr[n - 1] - arr[0];

        // smallest and largest represent the minimum and maximum values after modifying edge towers
        int smallest = arr[0] + k;  // increase the smallest height by k
        int largest = arr[n - 1] - k;  // decrease the largest height by k

        int min = 0, max = 0; // placeholders for current min and max in iterations

        // Iterate through the array to adjust towers between the minimum and maximum and minimize the range
        for (int i = 0; i < n - 1; i++) 
        {
            // Calculate the new minimum possible height
            min = Math.min(smallest, arr[i + 1] - k);

            // Calculate the new maximum possible height
            max = Math.max(largest, arr[i] + k);

            // If minimum goes below zero, skip as heights cannot be negative
            if (min < 0) 
                continue;

            // Update the answer with the minimum range found so far
            ans = Math.min(ans, max - min);
        }
        
        // Return the minimized maximum difference
        return ans;
    }
}

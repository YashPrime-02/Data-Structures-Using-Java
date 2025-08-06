/*
    Problem: Merge Overlapping Intervals in an Array

    Given an array of intervals, merge all overlapping intervals and return the result.
    Each interval is represented as a pair of integers [start, end].

    Approach:
      1. Sort the intervals based on their start times.
      2. Iterate through the sorted intervals and merge them if they overlap.
      3. If they do not overlap, add the current interval to the result list.
*/
// Time Complexity: O(n log n) for sorting, O(n) for merging = O(n log n)
// Space Complexity: O(n) for the result list
// Note: The input intervals are assumed to be non-empty and well-formed.
//       Each interval is represented as an array of two integers [start, end].
//       The output is a list of merged intervals, also represented as arrays of two integers.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    // Function to merge overlapping intervals
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Result list to store merged intervals
        ArrayList<int[]> ans = new ArrayList<>();

        // If input array is null or empty, just return empty result list
        if (arr == null || arr.length == 0) {
            return ans;
        }

        // Sort intervals by their start time using a Comparator
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // Compare start times of intervals
                if (a[0] < b[0]) return -1;
                else if (a[0] > b[0]) return 1;
                else return 0;
            }
        });

        // Iterate through all intervals
        for (int i = 0; i < arr.length; i++) {
            // If ans list is empty OR current interval's start is greater than
            // the end of the last interval in ans, no overlap: just add current interval
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{arr[i][0], arr[i][1]});
            } else {
                // Overlap detected:
                // Get last interval in ans list
                int[] last = ans.get(ans.size() - 1);
                // Merge by updating the end time to the max end time between last and current interval
                last[1] = Math.max(last[1], arr[i][1]);
            }
        }

        // Return the list of merged intervals
        return ans;
    }
}

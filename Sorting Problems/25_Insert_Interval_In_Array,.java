// Java program to insert a new interval into a list of sorted, non-overlapping intervals
// and merge any overlapping intervals
// Approach:
// 1. Iterate through the list of existing intervals.
// 2. Add all intervals **before** the new interval (no overlap).
// 3. Merge all intervals that **overlap** with the new interval.
// 4. Add all the remaining intervals after the new interval.
// Time Complexity: O(n) where n is the number of existing intervals.
// Space Complexity: O(n) for the result list.
// Note: The input intervals are assumed to be non-empty and well-formed.
//       Each interval is represented as an array of two integers [start, end].
//       The output is a list of merged intervals, also represented as arrays of two integers.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GfG {

    // Function to insert a new interval into a list of sorted, non-overlapping intervals
    // and merge any overlapping intervals
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();  // Result list to store merged intervals
        int i = 0;                                 // Index to iterate over intervals
        int n = intervals.length;                  // Number of existing intervals

        // 1. Add all intervals **before** the new interval (no overlap)
        // These are intervals where the end is less than the new interval's start
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2. Merge all intervals that **overlap** with the new interval
        // Overlap occurs if the current interval's start is less or equal to new interval's end
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Update the start of newInterval to the smallest start
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            // Update the end of newInterval to the largest end
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged newInterval
        res.add(newInterval);

        // 3. Add all the remaining intervals after the newInterval
        // These do not overlap with the new merged interval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Return the final list of merged intervals
        return res;
    }

}

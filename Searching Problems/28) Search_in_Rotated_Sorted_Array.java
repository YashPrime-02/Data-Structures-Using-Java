/**
 * Problem: Search in Rotated Sorted Array
 * ---------------------------------------
 * Given a sorted array that has been rotated at some unknown pivot,
 * find the index of a given key. Return -1 if the key doesn't exist.
 *
 * Time Complexity: O(log N) where N is the size of the array.
 *   - We use a modified binary search which reduces search space by half each iteration.
 *
 * Space Complexity: O(1)
 *   - We use constant extra space for variables.
 *
 * Explanation:
 * The array is rotated, so one side (left or right) of the mid element is sorted.
 * We check which side is sorted, then decide if the key lies within that side.
 * Accordingly, we move either left or right search boundaries.
 */

class Solution {
    int search(int[] arr, int key) {

        // Initialize search boundaries
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            // Mid index to split search space, safe from overflow
            int mid = low + (high - low) / 2;

            // Check if key found at mid
            if (arr[mid] == key)
                return mid;

            // Check if left half is sorted
            if (arr[mid] >= arr[low]) {
                // If key lies in left sorted half, narrow high pointer
                if (key >= arr[low] && key < arr[mid])
                    high = mid - 1;
                else
                    // Otherwise, look in the right half
                    low = mid + 1;
            } else {
                // Right half is sorted
                // If key lies in right sorted half, narrow low pointer
                if (key > arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    // Otherwise, search left half
                    high = mid - 1;
            }
        }

        // Key not found after exhausting search space
        return -1;
    }
}

/*
    Problem: Count Inversions in an Array (Using Merge Sort)
    --------------------------------------------------------
    - An inversion is a pair (i, j) such that i < j and arr[i] > arr[j].
    - This code efficiently counts how many such pairs exist in the array.
    - Time complexity: O(n log n) using divide-and-conquer/merge sort approach.
*/

class Solution {

    // Main function called by user: counts and returns number of inversions in the given array
    public int inversionCount(int[] arr) {
        // Create a copy to avoid modifying the original array
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Recursive merge sort that counts inversions as it sorts
    private int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            // Recursively count inversions in left half
            invCount += mergeSortAndCount(arr, temp, left, mid);
            // Recursively count inversions in right half
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            // Merge the two halves and count inversions during merge
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Merges two sorted subarrays and counts inversions
    private int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      // Starting index of left subarray
        int j = mid + 1;   // Starting index of right subarray
        int k = left;      // Starting index to write to temp array
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++]; // No inversion, copy left element
            } else {
                temp[k++] = arr[j++]; // Inversion found, copy right element
                invCount += (mid - i + 1); // All remaining elements in left > arr[j-1]
            }
        }

        // Copy any remaining elements from the left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // Copy any remaining elements from the right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // Copy back temp array to original arr
        for (int p = left; p <= right; p++) {
            arr[p] = temp[p];
        }

        return invCount;
    }
}

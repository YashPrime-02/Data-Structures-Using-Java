/*
    Problem: Count Inversions in an Array (Using Merge Sort)
    --------------------------------------------------------
    - An inversion is a pair (i, j) such that i < j and arr[i] > arr[j].
    - This code efficiently counts how many such pairs exist in the array.
    - Time complexity: O(n log n) using divide-and-conquer/merge sort approach.
*/

class Solution {

    // Main public function: counts and returns the number of inversions in the given array
    public int inversionCount(int[] arr) {
        int[] temp = new int[arr.length];           // Helper array for merges
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Recursive mergesort function that sorts the array and returns inversion count
    private int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            // Count inversions in left half
            invCount += mergeSortAndCount(arr, temp, left, mid);
            // Count inversions in right half
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            // Count split inversions during merge step
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Merges two sorted subarrays and counts the split inversions
    private int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;       // Pointer for left subarray
        int j = mid + 1;    // Pointer for right subarray
        int k = left;       // Pointer for temp array
        int invCount = 0;

        // Traverse both subarrays and merge
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++]; // No inversion, copy left element
            } else {
                temp[k++] = arr[j++]; // Inversion: copy right element
                invCount += (mid - i + 1); // All remaining left elements are greater than arr[j-1]
            }
        }

        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // Copy the remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // Copy the merged elements back to original array
        for (int p = left; p <= right; p++) {
            arr[p] = temp[p];
        }

        return invCount;
    }
}

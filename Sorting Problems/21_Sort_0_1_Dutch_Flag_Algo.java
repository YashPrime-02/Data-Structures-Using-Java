/*
    Problem: Sort an array of 0s, 1s, and 2s (Dutch National Flag Problem)

    Given an array consisting only of the numbers 0, 1, and 2,
    sort the array in ascending order (all 0s first, then 1s, then 2s).

    You should not use any built-in sorting function. 
    Your solution should work in O(n) time and use only O(1) extra space.

    Approach in this code:
      1. Count the number of 0s, 1s, and 2s in the array.
      2. Overwrite the original array with that many 0s, then 1s, then 2s.
      3. This method is called the "Counting" approach.
*/
class Solution {

    // Function to sort an array containing only 0s, 1s, and 2s in-place
    // Uses the Dutch National Flag algorithm (single pass, constant space)
    public void sort012(int[] arr) {
        int low = 0;                   // Points to the next position where 0 should go (start of array)
        int high = arr.length - 1;     // Points to the next position where 2 should go (end of array)
        int mid = 0;                   // Current element being considered

        // Continue until all elements are processed
        while (mid <= high) {
            if (arr[mid] == 0) {
                // If current element is 0, swap it with the element at 'low'
                // Increment both 'low' and 'mid' because those spots are now correct
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // If current element is 1, it's already at the right place
                // Just move to the next element
                mid++;
            } else {
                // If current element is 2, swap it with the element at 'high'
                // Move 'high' pointer backward, but don't move mid:
                // The swapped-in element at 'mid' must be checked again!
                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap elements at indices x and y in array arr
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];    // Store one value in temporary variable
        arr[x] = arr[y];      // Move value from arr[y] to arr[x]
        arr[y] = temp;        // Move temp (old arr[x]) to arr[y]
    }
}

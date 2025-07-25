// 04_Rotate_Array_by_k.java
// This Java program rotates an array to the right by k steps.
// The algorithm uses a three-step reversal technique to achieve the rotation in O(n) time complexity.
// Space complexity is O(1) since it modifies the array in place.
// The steps are: reverse the entire array, reverse the first k elements, and then reverse the remaining elements.
// This approach is efficient and avoids the need for additional space for a new array.
// The input array is modified directly to represent the rotated array.

class Solution {
    /**
     * Rotates the given array to the right by k steps.
     * Uses the reverse method to achieve rotation in O(n) time and O(1) space.
     *
     * @param arr The integer array to rotate
     * @param k   Number of steps to rotate the array
     */
    public void rotateArray(int arr[], int k) {
        int n = arr.length;
        
        // Handle cases where k >= n
        k = k % n; 
        
        // Reverse the entire array
        reverseArray(arr, 0, n - 1);
        
        // Reverse first k elements
        reverseArray(arr, 0, k - 1);
        
        // Reverse the remaining n-k elements
        reverseArray(arr, k, n - 1);
    }

    /**
     * Helper function to reverse elements in the array from index start to end inclusive.
     *
     * @param arr   The array to operate on
     * @param start Starting index
     * @param end   Ending index
     */
    private void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

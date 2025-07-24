// 03_Reverse_an_Array.java
// This Java program reverses an array in place.
// It uses a simple two-pointer technique to swap elements from the start and end towards the center.
// The algorithm works in O(n) time complexity, where n is the length of the array.
// Space complexity is O(1) since it modifies the array in place.
// The input array is modified directly to represent the reversed array.
// The function takes an integer array as input and reverses it without using any additional data structures
class Solution {
    /**
     * Reverses the elements of the given array in place.
     *
     * @param arr The array to be reversed
     */
    public void reverseArray(int arr[]) {
        int n = arr.length;
        int temp;

        // Swap elements from both ends moving towards the middle
        for (int i = 0; i < n / 2; i++) {
            temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}

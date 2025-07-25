// 02_Move_Zeroes.java
// This Java program moves all zeroes in an array to the end while maintaining the order of non-zero elements.
// The algorithm works in O(n) time complexity, where n is the length of the array.
// Space complexity is O(1) since it modifies the array in place.
// The input array is modified directly to represent the array with all zeroes moved to the end.
// The function takes an integer array as input and rearranges it without using any additional data structures.
// The approach uses a single pass to collect non-zero elements and then fills the rest of the array with zeroes.
// The function is efficient and straightforward, ensuring that the order of non-zero elements is preserved.
class Solution {
    /**
     * Moves all zeros in the array to the end while maintaining the order of non-zero elements.
     * Modifies the array in-place.
     * 
     * @param arr the input array of integers
     */
    void pushZerosToEnd(int[] arr) {
        int pos = 0; // position to place the next non-zero element
        
        // Traverse the array and move all non-zero elements to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos++] = arr[i];
            }
        }
        
        // Fill the remaining positions with zero
        while (pos < arr.length) {
            arr[pos++] = 0;
        }
    }
}

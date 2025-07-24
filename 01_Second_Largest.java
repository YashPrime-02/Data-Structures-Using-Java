// 01_Second_Largest.java
// This Java program finds the second largest element in an array.
// It iterates through the array to determine the largest and second largest elements.
// The algorithm works in O(n) time complexity, where n is the length of the array
// Space complexity is O(1) since it uses a fixed number of variables for tracking the largest and second largest elements.
// If the second largest element does not exist (e.g., all elements are the same), it returns -1.
// The function takes an integer array as input and returns the second largest element or -1 if
// it does not exist.
// The approach ensures that the order of elements is not altered, and it efficiently finds the second largest element.
class Solution {
    public int getSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;  // initialize max2 separately for clarity

        // Traverse the array once
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                // Current element is new maximum; update second max before max
                max2 = max;
                max = arr[i];
            } else if (arr[i] < max && arr[i] > max2) {
                // Current element is between max and max2, update max2
                max2 = arr[i];
            }
            // If arr[i] == max or arr[i] <= max2, do nothing
        }

        // If no valid second max found, return -1
        // max2 == max can happen if all elements are equal
        if (max2 == Integer.MIN_VALUE) {
            return -1;
        }
        return max2;
    }
}

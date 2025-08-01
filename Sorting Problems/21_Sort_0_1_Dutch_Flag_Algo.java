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
    static void sort012(int[] arr) {
        int n = arr.length;
        
        // initialize three pointers:
        // lo: boundary for 0s
        // mid: current element being checked
        // hi: boundary for 2s
        
        int lo = 0;
        int hi = n - 1;
        int mid = 0;
        
        // process elements until mid crosses hi
        while (mid <= hi) {
            if (arr[mid] == 0) {
                
                // current is 0: swap with lo and move both 
                // pointers forward
                int temp = arr[lo];
                arr[lo++] = arr[mid];
                arr[mid++] = temp;
            }
            else if (arr[mid] == 1) {
                // current is 1: it's already in correct position
                mid++;
            }
            else {
                // current is 2: swap with hi and move hi backward
                // do not increment mid, as swapped value needs
                // to be re-checked
                int temp = arr[mid];
                arr[mid] = arr[hi];
                arr[hi--] = temp;
            }
        }
    }

    
}
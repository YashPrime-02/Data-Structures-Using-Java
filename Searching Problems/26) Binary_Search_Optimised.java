/*
    Problem: Count Frequency of a Number in a Sorted Array (Lower Bound & Upper Bound)

    ---------------------------------------------------------------------------
    Given: 
      - A sorted array 'arr' (in non-decreasing order)
      - A target number 'target'

    Task:
      - Return how many times 'target' occurs in 'arr'.
      - Do this efficiently using binary search.
    
    Approach:
      - Use "lower bound" and "upper bound":
          * Lower Bound: The first index where arr[index] >= target.
          * Upper Bound: The first index where arr[index] > target.
      - The count of target in arr = (upper bound position) - (lower bound position).

    Functionality:
      - lowerBound(arr, target): Finds the first index at which target could be inserted 
        without breaking the order (i.e., first index >= target).
      - upperBound(arr, target): Finds the first index at which a value greater than 'target' 
        appears (i.e., first index > target).
      - countFreq(arr, target): Returns frequency of target using the above two functions.

    Time Complexity: O(log n) per query (using binary search)
    Space Complexity: O(1)
*/

class Solution {

    // Function to return Lower Bound
    static int lowerBound(int[] arr, int target) {
        int res = arr.length;
        
        // Search space for binary search
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) {
                res = mid;
                hi = mid - 1;
            } 
            else {
                lo = mid + 1;
            }
        }
        return res;
    }

    // Function to return Upper Bound
    static int upperBound(int[] arr, int target) {
        int res = arr.length;
        
        // Search space for binary search
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                res = mid;
                hi = mid - 1;
            } 
            else {
                lo = mid + 1;
            }
        }
        return res;
    }

    // Function to count frequency of target in arr
    static int countFreq(int[] arr, int target) {
        // Difference between upper bound and lower bound is the count
        return upperBound(arr, target) - 
                               lowerBound(arr, target);
    }

}

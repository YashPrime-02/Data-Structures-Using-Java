// Java program to find minimum element in a 
// sorted and rotated array using binary search
// Approach:
// 1. Use binary search to find the minimum element.
// 2. If the current subarray is already sorted,
//    the minimum is at the low index.
// 3. If the right half is not sorted, the minimum
//    element must be in the right half.
// 4. If the right half is sorted, we do not change

//    high to mid - 1 but keep it to mid, as the
//    mid element itself can be the smallest.
// Time Complexity: O(log n) where n is the number of elements in the array.
// Space Complexity: O(1) as we are using constant space.
// Note: The input array is assumed to be non-empty and well-formed.
// The array is rotated at some pivot, and all elements are distinct.


class Solution {
    static int findMin(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
          
            // The current subarray is already sorted, 
            // the minimum is at the low index
            if (arr[lo] < arr[hi])        
                return arr[lo];
               
            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
          
            int mid = (lo + hi) / 2;

            // The right half is not sorted. So 
            // the minimum element must be in the
            // right half.
            if (arr[mid] > arr[hi])
                lo = mid + 1;
          
            // The right half is sorted. Note that in 
            // this case, we do not change high to mid - 1
            // but keep it to mid. As the mid element
            // itself can be the smallest
            else
                hi = mid;
        }

        return arr[lo]; 
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}
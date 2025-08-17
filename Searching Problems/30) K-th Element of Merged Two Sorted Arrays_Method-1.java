/*
    Problem: Find the K-th element from two sorted arrays

    You are given:
      - Two sorted arrays (in ascending order)
      - An integer k
    Task:
      - Find the k-th smallest element from the combined data of both arrays.

    Approach Used Here:
      - Use a Min-Heap (Java PriorityQueue) to store all elements from both arrays.
      - Extract (remove) the smallest element from the heap until we reach the k-th element.
      - The element at the k-th extraction is our answer.

    Why Min-Heap works:
      - PriorityQueue in Java (without custom comparator) behaves as a min-heap.
      - The smallest element is always at the top (peek).
      - Removing k-1 smallest elements leaves the k-th element at the top.

    Time Complexity:
      - Adding all elements to heap: O((n + m) log(n + m))
      - Removing first k-1 elements: O(k log(n + m))
      Total: O((n + m) log(n + m))
    
    Space Complexity:
      - O(n + m) extra space for the heap.

    NOTE:
      This is not the most optimal method (merging two sorted arrays via two pointers is faster), 
      but it's easy to understand for beginners.
*/

import java.util.PriorityQueue; // Min-Heap

class Solution {

    // Function to find the k-th smallest element from two sorted arrays
    static int kthElement(int[] a, int[] b, int k) {

        // Create a min-heap (PriorityQueue default is min-heap in Java)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements from first array to the heap
        for (int value : a) {
            pq.add(value); // O(log size) for each insertion
        }

        // Add all elements from second array to the heap
        for (int value : b) {
            pq.add(value); // O(log size) for each insertion
        }

        // Remove elements from the heap until we reach the k-th smallest
        // We remove k-1 elements to put the k-th smallest at the top
        while (k > 1) {
            pq.poll(); // remove the smallest element
            k--;
        }

        // Return the current smallest element in the heap
        return pq.peek();
    }

    
}

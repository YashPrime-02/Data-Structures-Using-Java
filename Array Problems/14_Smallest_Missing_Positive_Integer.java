/**
 * Problem: Smallest Missing Positive Integer
 * ------------------------------------------
 * Given an integer array arr[], find the smallest missing positive integer.
 *
 * Approach:
 * - Use cyclic sort to place each number in its correct position.
 * - After sorting, the first index where the number does not match the index + 1 is the answer.
 * - If all numbers from 1 to n are present, return n + 1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int missingNumber(int[] arr) {
    int size=arr.length;
    for(int i=0;i<size;i++) // working in range
    {
     while((arr[i]>=1 && arr[i]<=size)&& arr[i]!=arr[arr[i]-1])
     // checking circular sort conditions of range and element for each element in every pass 
     {
     int temp =arr[i];
     arr[i]=arr[temp-1];
     arr[temp-1]=temp;
     }
    }
    
    // finding smallest positive missing
    for(int i=1;i<=size;i++)
    {
    if(i!=arr[i-1]) 
    
    return i;    
    
    }
    return size+1;
    }
}

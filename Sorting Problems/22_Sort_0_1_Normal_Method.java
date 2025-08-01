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
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) 
    {
        int counter = 0;      // This keeps track of the current position to place the value in the array

        int c0 = 0, c1 = 0, c2 = 0;   // These variables will count how many 0s, 1s, and 2s are in the array

        // First, count how many 0s, 1s, and 2s are present in the array
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 0)
                c0++;    // Add to the count of 0s
            else if (arr[i] == 1)
                c1++;    // Add to the count of 1s
            else if (arr[i] == 2)
                c2++;    // Add to the count of 2s
        }

        // Now, fill the array with all the 0s first
        for (int i = 0; i < c0; i++)
        {
            arr[counter++] = 0;
        }

        // Next, fill all the 1s
        for (int i = 0; i < c1; i++)
        {
            arr[counter++] = 1;
        }

        // Finally, fill all the 2s
        for (int i = 0; i < c2; i++)
        {
            arr[counter++] = 2;
        }
    }
}

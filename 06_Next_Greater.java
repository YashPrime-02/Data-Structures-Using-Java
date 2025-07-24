// 06_Next_Greater.java
// This Java program finds the next greater element for a given number m.
// It constructs the next permutation of the digits of m that is greater than m.
// If no such permutation exists, it returns -1.    
// The algorithm works in O(n) time complexity, where n is the number of digits in m.
// Space complexity is O(1) since we are using a fixed-size array for digit counts

class Solution {
    public int nextGreaterElement(int m) {
        long n = m;
        int[] count = new int[10];
        int currRem = -1;
        int prevRem = -1;

        while (n > 0) {
            currRem = (int)(n % 10);
            n = n / 10;
            count[currRem]++;

            // The key pivot detected when the next digit to the left is less than the digit to the right
            if (prevRem < currRem && prevRem != -1) {
                // Find the smallest digit greater than prevRem
                int num = prevRem + 1;
                while (num < 10 && count[num] == 0) num++;

                // Decrement count for the chosen digit and append it to the number
                count[num]--;
                n = n * 10 + num;

                // Append all remaining digits in ascending order
                for (int i = 0; i < 10; i++) {
                    while (count[i]-- > 0) {
                        n = n * 10 + i;
                    }
                }

                // Check for overflow and return result
                return n > Integer.MAX_VALUE ? -1 : (int) n;
            }
            prevRem = currRem;
        }

        // If no next greater permutation found
        return -1;
    }
}

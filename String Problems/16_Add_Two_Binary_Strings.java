/**
 * Problem: Add Two Binary Strings
 * --------------------------------
 * Given two binary strings s1 and s2 representing binary numbers,
 * return their sum as a binary string.
 * 
 * Important points:
 * - Input strings can have leading zeros.
 * - The output string should NOT have leading zeros (except if the sum is zero).
 * - Both inputs are non-empty and contain only '0' and '1'.
 * 
 * Example:
 * Input: s1 = "00101", s2 = "010"
 * Output: "111"
 *
 * Approach:
 * 1. Trim leading zeros from both input strings.
 * 2. Make sure the first string is longer (swap if necessary).
 * 3. Add bits from right to left with carry.
 * 4. Build up the result string in reverse order.
 * 5. Reverse the final result before returning.
 */

class Solution {

    // Helper method to remove leading zeros from a binary string
    // Returns "0" if the string only contains zeros
    public String trimzeroes(String s) {
        // Find index of first '1'
        int first = s.indexOf('1');
        // If no '1' found, return "0", else substring from first '1'
        return (first == -1) ? "0" : s.substring(first);
    }
    
    // Main method to add two binary strings
    public String addBinary(String s1, String s2) {
        
        // Remove leading zeros from s1
        s1 = trimzeroes(s1);
        // Remove leading zeros from s2
        s2 = trimzeroes(s2);
        
        // Store lengths of trimmed strings
        int n = s1.length();
        int m = s2.length();
        
        // If s1 is shorter than s2, swap and call again (to make s1 longest)
        if (n < m)
            return addBinary(s2, s1);
        
        // Pointer for s2 starting from its last character (least significant bit)
        int j = m - 1;
        // Carry for addition, initially zero
        int carry = 0;
        // Use StringBuilder for efficient string concatenation
        StringBuilder ans = new StringBuilder();
        
        // Traverse s1 from rightmost character to left (LSB to MSB)
        for (int i = n - 1; i >= 0; i--) {
            // Convert character digit to integer bit (0 or 1)
            int bit1 = s1.charAt(i) - '0';
            // Start sum with bit from s1 and current carry
            int sum = bit1 + carry;
            
            // If s2 has bits remaining, add that bit to sum
            if (j >= 0) {
                int bit2 = s2.charAt(j) - '0';
                sum += bit2;
                j--; // move pointer to next bit from right in s2
            }
            
            // Calculate the current bit of result (sum mod 2)
            int bit = sum % 2;
            // Update carry (sum divided by 2)
            carry = sum / 2;
            
            // Append the current bit as a character ('0' or '1') to the answer
            ans.append((char)(bit + '0'));
        }
        
        // After finishing all bits, if carry is still left, append it
        if (carry > 0)
            ans.append('1');
        
        // The result is built backwards, so reverse it to get correct order
        return ans.reverse().toString();
    }
}

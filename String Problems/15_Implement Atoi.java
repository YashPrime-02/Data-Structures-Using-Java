/**
 * Problem: String to Integer (atoi)
 * ---------------------------------
 * Given a string, convert it to a 32-bit signed integer (like the C/C++ atoi function).
 * The function first discards whitespace characters until the first non-whitespace character is found.
 * Then, from this character, it takes an optional initial plus or minus sign,
 * followed by as many numerical digits as possible,
 * and interprets them as a numerical value (ignoring the rest).
 * If the integer is outside the 32-bit signed integer range [-2^31, 2^31 - 1],
 * clamp it to the range and return the bound.
 *
 * Example:
 * Input:  "   -42abc"
 * Output: -42
 *
 * Constraints:
 * - Only the integer part of the string is considered.
 * - Non-integer characters after the integer are ignored.
 * - If no valid conversion exists, return 0.
 */

class Solution {
    public int myAtoi(String s) {
        int ans = 0;                    // Final result integer
        int flag = 0;                   // Pointer to scan characters in string
        int size = s.length();          // Length of the input string
        int sign = 1;                   // Sign of the result (+1 for positive, -1 for negative)

        // 1. Skip leading whitespaces
        while (flag < size && s.charAt(flag) == ' ')
            flag++;

        // 2. Check for optional '+' or '-' sign
        if (flag < size && (s.charAt(flag) == '+' || s.charAt(flag) == '-')) {
            if (s.charAt(flag) == '-') 
                sign = -1;              // Set sign to negative if '-' found
            flag++;                     // Move to next character
        }

        // 3. Process digits and convert to integer
        while (flag < size && (s.charAt(flag) >= '0' && s.charAt(flag) <= '9')) {
            int digit = s.charAt(flag) - '0'; // Convert character to integer

            // 4. Handle integer overflow/underflow:
            // If including this digit would put ans out of 32-bit int range, clamp and return
            if (ans > (Integer.MAX_VALUE - digit) / 10)
                return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);

            ans = ans * 10 + digit;     // Append digit to result
            flag++;                     // Move to next character
        }

        // 5. Return final signed result
        return ans * sign;
    }
}

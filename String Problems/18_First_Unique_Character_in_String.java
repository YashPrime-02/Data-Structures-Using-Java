// Class to find the first non-repeating (unique) character in a string
// This is a Java program to find the first non-repeating character in a string.
// A non-repeating character is one that appears exactly once in the string.
// The program uses a frequency array to count occurrences of each character.
// Time Complexity: O(n), where n is the length of the string.
// Space Complexity: O(1), since the frequency array size is constant (26 for lowercase letters).
// The program returns the first non-repeating character or '$' if none exists.

class Solution {

    // Method to find the first non-repeating (unique) character in a string
    // Returns the character if found, or '$' if there is no non-repeating character
    static char nonRepeatingChar(String s) {
        // Create an array to count frequency for each lowercase letter ('a' to 'z')
        int[] freq = new int[26];  // freq[i] = number of times character ('a' + i) appears

        // First loop: Count frequency of every character in the string
        for (char c : s.toCharArray()) {
            // Subtract 'a' to convert character to index (e.g. 'a' -> 0, 'b' -> 1, ..., 'z' -> 25)
            freq[c - 'a']++;    
        }

        // Second loop: Look for the first character in s whose frequency is 1
        for (char c : s.toCharArray()) {
            // If frequency is 1, this character is non-repeating
            if (freq[c - 'a'] == 1)
                return c;
        }

        // If no non-repeating character is found, return '$' as a placeholder
        return '$';
    }
}

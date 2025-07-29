
// This is a Java program to check if two strings are anagrams of each other.
// An anagram is a word or phrase formed by rearranging the letters of a different word
// or phrase, typically using all the original letters exactly once.
// The program uses a frequency array to count occurrences of each character in both strings.
// If the frequency counts match for all characters, the strings are anagrams.
// Time Complexity: O(n), where n is the length of the strings.
// Space Complexity: O(1), since the frequency array size is constant (26 for lowercase letters).

class Solution {

    // Method to check if two strings are anagrams of each other
    static boolean areAnagrams(String s1, String s2) {
        
        // If lengths differ, they cannot be anagrams
        if (s1.length() != s2.length()) 
            return false;
        
        // Frequency array for all lowercase letters 'a' to 'z'
        // freq[i] will hold the difference in frequency of character 'a'+i between s1 and s2
        int[] freq = new int[26];  

        // Count the frequency of each character in s1
        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;  // increment count for character in s1

        // Decrease the frequency for each character in s2
        for (int i = 0; i < s2.length(); i++)
            freq[s2.charAt(i) - 'a']--;  // decrement count for character in s2

        // Check if all counts are zero, meaning s1 and s2 have same frequency for each character
        for (int count : freq) {
            if (count != 0)
                return false;  // Found a mismatch in frequencies
        }

        // All frequencies matched, strings are anagrams
        return true;
    }

}

// We are using Moore's Voting Algorithm two elements version
// to find all elements that appear more than n/3 times in the array.
// This algorithm works in O(n) time and O(1) space complexity.
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    /**
     * Finds all elements in the array that appear more than n/3 times.
     * Uses the extended Boyer-Moore Voting Algorithm with two candidates.
     * 
     * @param arr Input array of integers representing votes/candidates
     * @return A sorted list of majority elements appearing more than n/3 times
     */
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge case: empty input
        if (n == 0) return result;

        // Initialize two potential candidates and their counters
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // **1st Pass: Find two potential candidates**
        // The idea is that there can be at most two elements with frequency > n/3
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                // Reduce both counts if current element matches neither candidate
                count1--;
                count2--;
            }
        }

        // **2nd Pass: Verify the candidates by counting their occurrences**
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        // If candidates occur more than floor(n/3) times, add to result
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Sort result in ascending order, as per problem requirement
        Collections.sort(result);

        return result;
    }
}

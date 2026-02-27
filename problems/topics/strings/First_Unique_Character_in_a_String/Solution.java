/**
 * 387. First Unique Character in a String
 * 
 * Approach: Frequency Array (Two Pass)
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package problems.topics.strings.First_Unique_Character_in_a_String;

class Solution {
    public int firstUniqChar(String s) {
        // frequency array for 26 lowercase English letters
        int[] freq = new int[26];

        // First Pass: count occurrences
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Second Pass: find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("leetcode: " + solution.firstUniqChar("leetcode")); // Expected: 0

        // Test Case 2
        System.out.println("loveleetcode: " + solution.firstUniqChar("loveleetcode")); // Expected: 2

        // Test Case 3
        System.out.println("aabb: " + solution.firstUniqChar("aabb")); // Expected: -1
    }
}

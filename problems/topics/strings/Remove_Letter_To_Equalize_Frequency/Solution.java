package problems.topics.strings.Remove_Letter_To_Equalize_Frequency;

/**
 * 2423. Remove Letter To Equalize Frequency
 * 
 * Approach: Brute Force (Trying to remove each character)
 * Time Complexity: O(N * N)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean equalFrequency(String word) {
        // Since the constraint is small (length <= 100), we can try removing each index
        for (int i = 0; i < word.length(); i++) {
            int[] freq = new int[26];

            // Count frequency of all characters except the one at index i
            for (int j = 0; j < word.length(); j++) {
                if (i == j)
                    continue;
                freq[word.charAt(j) - 'a']++;
            }

            // Validate if all present frequencies are equal
            int target = 0;
            boolean valid = true;

            for (int f : freq) {
                if (f == 0)
                    continue;

                if (target == 0) {
                    target = f;
                } else if (target != f) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Input: \"abcc\", Output: " + solution.equalFrequency("abcc")); // Expected: true

        // Test Case 2
        System.out.println("Input: \"aazz\", Output: " + solution.equalFrequency("aazz")); // Expected: false

        // Test Case 3 (All same)
        System.out.println("Input: \"aaaa\", Output: " + solution.equalFrequency("aaaa")); // Expected: true
    }
}

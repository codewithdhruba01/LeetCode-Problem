package problems.topics.strings.Valid_Anagram;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case 1: " + (solution.isAnagram("anagram", "nagaram") == true ? "Passed" : "Failed")); // Expected:
                                                                                                                        // true

        // Test Case 2
        System.out.println("Test Case 2: " + (solution.isAnagram("rat", "car") == false ? "Passed" : "Failed")); // Expected:
                                                                                                                 // false
    }
}

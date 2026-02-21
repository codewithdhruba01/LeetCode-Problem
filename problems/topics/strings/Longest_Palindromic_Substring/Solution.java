package problems.topics.strings.Longest_Palindromic_Substring;

/**
 * 5. Longest Palindromic Substring
 * 
 * Approach: Expand Around Center
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around character (odd length palindrome)
            int len1 = expandAroundCenter(s, i, i);

            // Expand around gap (even length palindrome)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // If we found a longer palindrome, update start and end indices
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // The palindrome length is (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        System.out.println("Input: 'babad', Expected: 'bab' or 'aba', Result: " + solution.longestPalindrome("babad"));
        System.out.println("Input: 'cbbd', Expected: 'bb', Result: " + solution.longestPalindrome("cbbd"));
        System.out.println("Input: 'a', Expected: 'a', Result: " + solution.longestPalindrome("a"));
        System.out.println("Input: 'ac', Expected: 'a' or 'c', Result: " + solution.longestPalindrome("ac"));
    }
}

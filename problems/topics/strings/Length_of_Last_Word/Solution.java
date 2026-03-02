package problems.topics.strings.Length_of_Last_Word;

/**
 * 58. Length of Last Word
 * 
 * Approach: Right-to-Left Traversal
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Step 1: Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count last word length
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Input: \"Hello World\", Output: " + solution.lengthOfLastWord("Hello World")); // Expected:
                                                                                                           // 5

        // Test Case 2
        System.out.println("Input: \"   fly me   to   the moon  \", Output: "
                + solution.lengthOfLastWord("   fly me   to   the moon  ")); // Expected: 4

        // Test Case 3
        System.out.println(
                "Input: \"luffy is still joyboy\", Output: " + solution.lengthOfLastWord("luffy is still joyboy")); // Expected:
                                                                                                                    // 6
    }
}

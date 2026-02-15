package problems.topics.strings.Reverse_Words_in_a_String;

class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0)
                break;

            int j = i; // End of the word
            // Find start of the word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Append word
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(s.substring(i + 1, j + 1));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "the sky is blue";
        System.out
                .println("Test Case 1: " + (solution.reverseWords(s1).equals("blue is sky the") ? "Passed" : "Failed")); // Expected:
                                                                                                                         // "blue
                                                                                                                         // is
                                                                                                                         // sky
                                                                                                                         // the"

        // Test Case 2
        String s2 = "  hello world  ";
        System.out.println("Test Case 2: " + (solution.reverseWords(s2).equals("world hello") ? "Passed" : "Failed")); // Expected:
                                                                                                                       // "world
                                                                                                                       // hello"

        // Test Case 3
        String s3 = "a good   example";
        System.out
                .println("Test Case 3: " + (solution.reverseWords(s3).equals("example good a") ? "Passed" : "Failed")); // Expected:
                                                                                                                        // "example
                                                                                                                        // good
                                                                                                                        // a"
    }
}

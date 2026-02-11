package problems.topics.strings.Longest_Common_Prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String[] strs1 = { "flower", "flow", "flight" };
        System.out.println("Test Case 1: " + (solution.longestCommonPrefix(strs1).equals("fl") ? "Passed" : "Failed")); // Expected:
                                                                                                                        // "fl"

        // Test Case 2
        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println("Test Case 2: " + (solution.longestCommonPrefix(strs2).equals("") ? "Passed" : "Failed")); // Expected:
                                                                                                                      // ""

        // Test Case 3
        String[] strs3 = { "ab", "a" };
        System.out.println("Test Case 3: " + (solution.longestCommonPrefix(strs3).equals("a") ? "Passed" : "Failed")); // Expected:
                                                                                                                       // "a"
    }
}

package problems.topics.strings.Reverse_String;

import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        char[] s1 = { 'h', 'e', 'l', 'l', 'o' };
        solution.reverseString(s1);
        System.out.println(
                "Test Case 1: " + (Arrays.equals(s1, new char[] { 'o', 'l', 'l', 'e', 'h' }) ? "Passed" : "Failed"));

        // Test Case 2
        char[] s2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        solution.reverseString(s2);
        System.out.println("Test Case 2: "
                + (Arrays.equals(s2, new char[] { 'h', 'a', 'n', 'n', 'a', 'H' }) ? "Passed" : "Failed"));
    }
}

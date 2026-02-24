package problems.topics.strings.Rotate_String;

/**
 * 796. Rotate String
 * 
 * Approach: Brute Force Rotation Simulation
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths don't match, one cannot be a rotation of the other
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();

        // Try all possible shifts from 0 to n-1
        for (int shift = 0; shift < n; shift++) {
            boolean match = true;

            // For each shift, check every character
            for (int i = 0; i < n; i++) {
                // (i + shift) % n gives the index in the original string s
                // after it has been rotated 'shift' times
                if (s.charAt((i + shift) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }

            // If all characters matched for this shift
            if (match) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println("Test Case 1: " + solution.rotateString(s1, goal1)); // Expected: true

        // Test Case 2
        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println("Test Case 2: " + solution.rotateString(s2, goal2)); // Expected: false
    }
}

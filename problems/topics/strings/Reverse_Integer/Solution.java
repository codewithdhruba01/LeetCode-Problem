package problems.topics.strings.Reverse_Integer;

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before updating rev
            // If rev > MAX/10, then rev*10 will overflow
            // If rev == MAX/10, then we check the last digit (MAX is 2147483647)
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            // If rev < MIN/10, then rev*10 will underflow
            // If rev == MIN/10, then we check the last digit (MIN is -2147483648)
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case 1: " + (solution.reverse(123) == 321 ? "Passed" : "Failed")); // Expected: 321

        // Test Case 2
        System.out.println("Test Case 2: " + (solution.reverse(-123) == -321 ? "Passed" : "Failed")); // Expected: -321

        // Test Case 3
        System.out.println("Test Case 3: " + (solution.reverse(120) == 21 ? "Passed" : "Failed")); // Expected: 21

        // Test Case 4 (Overflow)
        System.out.println("Test Case 4: " + (solution.reverse(1534236469) == 0 ? "Passed" : "Failed")); // Expected: 0
    }
}

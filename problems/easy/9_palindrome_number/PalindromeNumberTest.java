
/**
 * LeetCode Problem: Palindrome Number
 * 
 * Standalone Test File
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }
}

public class PalindromeNumberTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.isPalindrome(121) == true;
        assert solution.isPalindrome(-121) == false;
        assert solution.isPalindrome(10) == false;
        assert solution.isPalindrome(0) == true;

        System.out.println("All tests passed!");
    }
}

class Solution:
    def isPalindrome(self, x: int) -> bool:
        """
        Determine whether an integer is a palindrome.
        An integer is a palindrome when it reads the same backward as forward.
        """
        # Special cases:
        # If x is negative, it's not a palindrome.
        # If the last digit is 0, the first digit must also be 0 (only possible for x=0).
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        reversed_half = 0
        while x > reversed_half:
            reversed_half = reversed_half * 10 + x % 10
            x //= 10
            
        # When the length is odd, we can get rid of the middle digit by reversed_half // 10
        return x == reversed_half or x == reversed_half // 10

# Complexity Analysis:
# Time: O(log10(n))
# Space: O(1)

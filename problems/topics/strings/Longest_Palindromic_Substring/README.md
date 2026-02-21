# 5. Longest Palindromic Substring

[LeetCode Problem Link](https://leetcode.com/problems/longest-palindromic-substring/)

## Description

Given a string `s`, return the longest **palindromic substring** in `s`.

## Examples

**Example 1:**

```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
```

**Example 2:**

```
Input: s = "cbbd"
Output: "bb"
```

## Constraints

- `1 <= s.length <= 1000`
- `s` consist of only digits and English letters.

## Approach: Expand Around Center

The idea is to consider each character (and the gap between characters) as a potential center of a palindrome and expand outwards as long as the substring remains a palindrome.

### Intuition

1. A palindrome mirrors around its center.
2. There are `2n - 1` such centers:
   - `n` centers are the characters themselves (for odd-length palindromes).
   - `n - 1` centers are the gaps between characters (for even-length palindromes).
3. For each center, expand as far as possible.
4. Keep track of the start and end indices of the maximum length palindrome found so far.

### Complexity Analysis

- **Time Complexity:** `O(N^2)`, where `N` is the length of the string. We expand around `2N-1` centers, and each expansion can take `O(N)`.
- **Space Complexity:** `O(1)`, as we only store the start and end pointers.

## Code (Java)

```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // Odd length
            int len2 = expandAroundCenter(s, i, i + 1); // Even length
            int len = Math.max(len1, len2);
            
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
        return right - left - 1;
    }
}
```

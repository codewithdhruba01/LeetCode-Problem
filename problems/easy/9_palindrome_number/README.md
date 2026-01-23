# 9. Palindrome Number

## Problem Description

Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

### Example 1:
**Input:** `x = 121`  
**Output:** `true`  
**Explanation:** `121` reads as `121` from left to right and from right to left.

### Example 2:
**Input:** `x = -121`  
**Output:** `false`  
**Explanation:** From left to right, it reads `-121`. From right to left, it becomes `121-`. Therefore it is not a palindrome.

### Example 3:
**Input:** `x = 10`  
**Output:** `false`  
**Explanation:** Reads `01` from right to left. Therefore it is not a palindrome.

---

## Approach

Instead of reversing the whole number (which might cause overflow for large integers), we can reverse only **half** of the number.

1. Handle edge cases: Negative numbers and numbers ending in 0 (except 0 itself) cannot be palindromes.
2. Maintain a `reversedHalf` variable.
3. In a loop, extract the last digit from `x` and append it to `reversedHalf` until `x` is no longer greater than `reversedHalf`.
4. At the end, compare `x` with `reversedHalf`:
   - If the number of digits is even, `x` should equal `reversedHalf`.
   - If the number of digits is odd, `x` should equal `reversedHalf / 10` (to ignore the middle digit).

## Complexity Analysis

- **Time Complexity:** $O(\log_{10}(n))$, where $n$ is the input number. We divide the number by 10 in every iteration.
- **Space Complexity:** $O(1)$. We only use a constant amount of extra space.

---

## LeetCode Link
[Palindrome Number](https://leetcode.com/problems/palindrome-number/)

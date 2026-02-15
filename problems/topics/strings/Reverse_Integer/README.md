# 7. Reverse Integer

[LeetCode Problem Link](https://leetcode.com/problems/reverse-integer/)

## Description

Given a signed 32-bit integer `x`, return `x` *with its digits reversed*. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.

**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**

## Examples

**Example 1:**

```
Input: x = 123
Output: 321
```

**Example 2:**

```
Input: x = -123
Output: -321
```

**Example 3:**

```
Input: x = 120
Output: 21
```

## Constraints

-   `-2^31 <= x <= 2^31 - 1`

## Approach: Mathematical Reversal with Overflow Check

We can reverse an integer by repeatedly popping the last digit and pushing it to the back of the reversed number. However, we must carefully check for overflow before updating the reversed number.

### Intuition

1.  Use `x % 10` to get the last digit.
2.  Use `x / 10` to remove the last digit.
3.  Update the reversed number: `rev = rev * 10 + digit`.
4.  **Overflow Check:** Before multiplying `rev` by 10, check if it will exceed `Integer.MAX_VALUE` or fall below `Integer.MIN_VALUE`. Since we are adding a digit (0-9), we can check if `rev > Integer.MAX_VALUE / 10` or `rev < Integer.MIN_VALUE / 10`.

### Complexity Analysis

-   **Time Complexity:** `O(log(x))`. There are roughly `log10(x)` digits in `x`.
-   **Space Complexity:** `O(1)`. We only use a few variables.

## Code (Java)

```java
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before updating rev
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
        }
        return rev;
    }
}
```

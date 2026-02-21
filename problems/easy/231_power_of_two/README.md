# 231. Power of Two

[LeetCode Problem Link](https://leetcode.com/problems/power-of-two/)

## Description

Given an integer `n`, return `true` if it is a power of two. Otherwise, return `false`.

An integer `n` is a power of two, if there exists an integer `x` such that `n == 2^x`.

## Examples

**Example 1:**

```
Input: n = 1
Output: true
Explanation: 2^0 = 1
```

**Example 2:**

```
Input: n = 16
Output: true
Explanation: 2^4 = 16
```

**Example 3:**

```
Input: n = 3
Output: false
```

## Constraints

- `-2^31 <= n <= 2^31 - 1`

## Approach: Bit Manipulation

A property of numbers that are powers of two in binary representation is that they have exactly one bit set to `1`.

### Intuition

1. If `n <= 0`, it cannot be a power of two.
2. If `n` is a power of two, its binary representation looks like `100...0`.
3. Subtracting 1 from such a number flips the `1` to `0` and all trailing `0`s to `1`s (e.g., `1000 - 1 = 0111`).
4. Performing a bitwise AND between `n` and `n - 1` will result in `0` if and only if `n` has exactly one bit set.
   - `n & (n - 1) == 0`

### Complexity Analysis

- **Time Complexity:** `O(1)`. The bitwise operation is performed in constant time.
- **Space Complexity:** `O(1)`. No extra space is used.

## Code (Java)

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```

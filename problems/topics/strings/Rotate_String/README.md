# 796. Rotate String

[LeetCode Problem Link](https://leetcode.com/problems/rotate-string/)

## Description

Given two strings `s` and `goal`, return `true` *if and only if* `s` *can become* `goal` *after some number of **shifts** on* `s`.

A **shift** on `s` consists of moving the leftmost character of `s` to the rightmost position.

- For example, if `s = "abcde"`, then it will be `"bcdea"` after one shift.

## Examples

**Example 1:**
```
Input: s = "abcde", goal = "cdeab"
Output: true
```

**Example 2:**
```
Input: s = "abcde", goal = "abced"
Output: false
```

## Constraints

- `1 <= s.length, goal.length <= 100`
- `s` and `goal` consist of lowercase English letters.

## Approach: Brute Force (Rotation Simulation)

We can simulate every possible rotation of `s` and check if it matches `goal`.

### Intuition

1. If the lengths of `s` and `goal` are different, `s` can never become `goal`.
2. We try shifting `s` by `0` to `n-1` positions.
3. For each shift, we check if all characters match `goal` using the formula `(i + shift) % n` to find the corresponding index in the original string `s`.

### Complexity Analysis

- **Time Complexity:** `O(N^2)`, where `N` is the length of the string. We have two nested loops, each running up to `N` times.
- **Space Complexity:** `O(1)`. We only use a few variables for indexing; no extra space is used.

## Code (Java)

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();

        for (int shift = 0; shift < n; shift++) {
            boolean match = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt((i + shift) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
```

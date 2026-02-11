# 344. Reverse String

[LeetCode Problem Link](https://leetcode.com/problems/reverse-string/)

## Description

Write a function that reverses a string. The input string is given as an array of characters `s`.

You must do this by modifying the input array **in-place** with `O(1)` extra memory.

## Examples

**Example 1:**

```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

**Example 2:**

```
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

## Constraints

-   `1 <= s.length <= 10^5`
-   `s[i]` is a printable ascii character.

## Approach: Two Pointers

The most efficient way to solve this problem in-place is using the **Two Pointers** technique.

### Intuition

We can maintain two pointers:
1.  `left` starting at the beginning of the string (index `0`).
2.  `right` starting at the end of the string (index `s.length - 1`).

While `left < right`:
-   Swap the characters at `s[left]` and `s[right]`.
-   Move `left` one step forward (`left++`).
-   Move `right` one step backward (`right--`).

This process effectively reverses the string by swapping characters from the outside in.

### Complexity Analysis

-   **Time Complexity:** `O(N)`, where `N` is the length of the string `s`. We swap `N/2` times.
-   **Space Complexity:** `O(1)`, as we modify the input array in-place and use constant extra space for the `temp` variable.

## Code (Java)

```java
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
}
```

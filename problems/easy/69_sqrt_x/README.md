# 69. Sqrt(x)

[LeetCode Problem Link](https://leetcode.com/problems/sqrtx/)

## Description

Given a non-negative integer `x`, return the square root of `x` rounded down to the nearest integer. The returned integer should be **non-negative** as well.

You **must not use** any built-in exponent function or operator.
-   For example, do not use `pow(x, 0.5)` in C++ or `x ** 0.5` in python.

## Examples

**Example 1:**

```
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
```

**Example 2:**

```
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
```

## Constraints

-   `0 <= x <= 2^31 - 1`

## Approach: Binary Search

Since `x` is non-negative, its square root will be between `0` and `x`. The square root function is monotonic, so we can use **Binary Search** to find the answer.

### Intuition

We are looking for an integer `k` such that `k * k <= x` and `(k + 1) * (k + 1) > x`.
Range for binary search: `[1, x]`. Use `x/2` as upper bound for `x >= 4` to optimize, but `[1, x]` is safe.

**Algorithm:**
1.  Handle base case: if `x < 2`, return `x`.
2.  Initialize `left = 1`, `right = x / 2` (or simply `x`).
3.  While `left <= right`:
    -   Calculate `mid = left + (right - left) / 2`.
    -   To avoid integer overflow with `mid * mid`, compare `mid` with `x / mid`.
    -   If `mid == x / mid`, we found the exact square root, return `mid`.
    -   If `mid < x / mid`, `mid` is small, so we move right: `left = mid + 1`.
    -   If `mid > x / mid`, `mid` is too large, so we move left: `right = mid - 1`.
4.  Return `right`. Since the loop ends when `left > right`, `right` will be the largest integer whose square is less than or equal to `x`.

### Complexity Analysis

-   **Time Complexity:** `O(log x)`. Binary search cuts the search space in half each time.
-   **Space Complexity:** `O(1)`. We only use a few variables.

## Code (Java)

```java
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        
        int left = 1;
        int right = x / 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid == x / mid) {
                return mid;
            }
            
            if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
}
```

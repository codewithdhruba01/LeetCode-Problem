# 2481. Minimum Cuts to Divide a Circle

[LeetCode Problem Link](https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/)

## Description

A **valid cut** in a circle can be:
- A cut that is represented by a straight line that touches two points on the edge of the circle and passes through its center, or
- A cut that is represented by a straight line that touches one point on the edge of the circle and its center.

Given the integer `n`, return the *minimum number of cuts needed to divide a circle into `n` equal slices*.

## Examples

**Example 1:**
![Example 1](https://assets.leetcode.com/uploads/2022/10/29/11.jpg)
```
Input: n = 4
Output: 2
Explanation: 
The above figure shows how cutting the circle twice through the middle divides it into 4 equal slices.
```

**Example 2:**
![Example 2](https://assets.leetcode.com/uploads/2022/10/24/22.jpg)
```
Input: n = 3
Output: 3
Explanation: 
At least 3 cuts are needed to divide the circle into 3 equal slices. 
It can be shown that less than 3 cuts cannot result in 3 slices of equal size and shape.
Also note that the first cut will not divide the circle into distinct parts.
```

## Constraints

- `1 <= n <= 100`

## Approach: Mathematical Parity

This is a geometry/math problem that depends on whether `n` is even or odd.

### Intuition

1. **Case n = 1**: If we need only 1 slice, we already have it (the whole circle). No cuts are needed. **Output: 0**.
2. **Case n is Even**: If `n` is even, every cut that passes through the center (a diameter) creates two equal halves. If we make `n/2` such diameter cuts, we get `2 * (n/2) = n` equal slices. This is more efficient than making individual radius cuts. **Output: n / 2**.
3. **Case n is Odd**: If `n` is odd, a cut through the center would produce two equal halves, which doesn't help in getting an odd number of slices directly. We must make `n` cuts from the center to the edge (radii) to get `n` equal slices. **Output: n**.

### Complexity Analysis

- **Time Complexity:** $O(1)$.
- **Space Complexity:** $O(1)$.

## Code (Java)

```java
class Solution {
    public int numberOfCuts(int n) {
        // Base case: 1 slice means no cuts
        if (n == 1) return 0;
        
        // If n is even, we can use diameter cuts (n/2 cuts)
        if (n % 2 == 0) {
            return n / 2;
        } else {
            // If n is odd, we must use radius cuts (n cuts)
            return n;
        }
    }
}
```

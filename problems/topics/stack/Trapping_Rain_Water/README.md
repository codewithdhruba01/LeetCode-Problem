# 42. Trapping Rain Water

[LeetCode Problem Link](https://leetcode.com/problems/trapping-rain-water/)

## Description

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

## Examples

**Example 1:**
![Example 1](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)
```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
```

**Example 2:**
```
Input: height = [4,2,0,3,2,5]
Output: 9
```

## Constraints

- `n == height.length`
- `1 <= n <= 2 * 10^4`
- `0 <= height[i] <= 10^5`

---

## Approach 1: Two Pointers (Optimal)

This approach uses two pointers moving from both ends towards the center.

### Intuition
1. Water trapped at any index `i` depends on the `min(max_left_until_i, max_right_from_i) - height[i]`.
2. Instead of precalculating max arrays, we maintain `leftMax` and `rightMax` on the fly.
3. If `height[l] < height[r]`, we are certain that `height[l]` is capped by a wall on the right (since `height[r]` is already taller). Thus, the water at `l` depends only on `leftMax`.
4. Similarly, if `height[r] <= height[l]`, water at `r` depends on `rightMax`.

### Complexity Analysis
- **Time Complexity:** $O(N)$
- **Space Complexity:** $O(1)$

---

## Approach 2: Monotonic Stack

This approach calculates water trapped **horizontally** in blocks.

### Intuition
1. Use a stack to store indices of bars in **decreasing** order of height.
2. When we find a bar `height[i]` taller than the stack's top, it means we found a right boundary.
3. The popped element `top` is the bottom of the "pool", and the current element `i` and the new `stack.peek()` are the boundaries.
4. Water Volume = `distance * (min(height[i], height[stack.peek()]) - height[top])`.

### Complexity Analysis
- **Time Complexity:** $O(N)$
- **Space Complexity:** $O(N)$

---

## Code (Java - Two Pointer)

```java
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    water += leftMax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    water += rightMax - height[r];
                }
                r--;
            }
        }
        return water;
    }
}
```

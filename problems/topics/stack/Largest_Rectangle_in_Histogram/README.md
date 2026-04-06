# 84. Largest Rectangle in Histogram

[LeetCode Problem Link](https://leetcode.com/problems/largest-rectangle-in-histogram/)

## Description

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return the area of the largest rectangle in the histogram.

## Examples

**Example 1:**
![Histogram Example 1](https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg)
```
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
```

**Example 2:**
![Histogram Example 2](https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg)
```
Input: heights = [2,4]
Output: 4
```

## Constraints

- `1 <= heights.length <= 10^5`
- `0 <= heights[i] <= 10^4`

## Approach: Monotonic Stack ($O(N)$)

The goal is to find the largest rectangle that can be formed using each bar as the **minimum height**. To do this efficiently, we need to find the nearest smaller bar to the left and right for every bar.

### Intuition

1. **Stack Property**: We maintain a **monotonic increasing stack** of indices.
2. **Expansion**: When we encounter a bar that is shorter than the bar at the stack's top, it means we've found the right boundary for the rectangle formed by the stack's top bar. 
    - The **height** is `heights[stack.pop()]`.
    - The **width** is the distance between the current index `i` (right boundary) and the new stack top (left boundary).
3. **Guard Logic**: To handle the end of the array, we iterate up to `i = n` and treat `heights[n]` as `0` to force popping all remaining elements from the stack.

### Complexity Analysis

- **Time Complexity:** $O(N)$. Each index is pushed and popped from the stack exactly once.
- **Space Complexity:** $O(N)$ for the stack in the worst case (increasing heights).

## Code (Java)

```java
import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= n; i++) {
            // Treat the index after the array as a bar with height 0
            int h = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}
```

# Revision Notes: Max Consecutive Ones III

## Core Concept
- **Sliding Window**: The problem asks for the longest subarray with a specific property (at most `k` zeros). Sliding window is the standard `O(N)` approach for this.
- **Dynamic Window Size**: Unlike fixed-size sliding windows, this window expands until a condition is violated, then shrinks until it is valid again.

## Algorithm Logic
1. `right` expands the window and "consumes" a 1 or a 0.
2. `zeroCount` tracks how many zeros are currently flipped to ones.
3. `while (zeroCount > k)`: The window is invalid. Move `left` to shrink it and potentially "un-flip" a zero.
4. `maxLen = Math.max(..., right - left + 1)`: The size of the valid window is calculated at each step.

## Key Insights
- **Translation**: "Flip at most `k` zeros" is equivalent to "Find a subarray with at most `k` zeros."
- **One-Pass**: We don't need to try every starting position. The two pointers efficiently cover the search space.

## Complexity
- **Time Complexity**: `O(N)` — Each index is visited at most once by each pointer.
- **Space Complexity**: `O(1)` — No auxiliary data structures used.

## Related Problems
- Longest Subarray of 1's After Deleting One Element (Leecode 1493)
- Longest Repeating Character Replacement (Leetcode 424)

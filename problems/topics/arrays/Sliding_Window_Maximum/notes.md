# Revision Notes: Sliding Window Maximum

## Core Concept
- **Monotonic Queue Pattern**: The fundamental idea is to keep a queue of indices where the values are either non-increasing or non-decreasing. Here, we need a strictly decreasing queue to find the maximum.
- **Why Deque?**: We need to remove elements from both ends.
    - Remove from **Front**: When indices fall out of the sliding window.
    - Remove from **Back**: To maintain the monotonic property (removing smaller elements).

## Algorithm Steps
1. **Window Maintenance**: If the index at the head is `i - k`, it's time to pop it from the front.
2. **Monotonicity**: Before adding current index `i`, pop all indices from the back whose values are `< nums[i]`.
3. **Recording Result**: Once we've seen at least `k` elements (`i >= k - 1`), the head of the deque is our answer for that window.

## Key Insights
- **Indices vs. Values**: Always store **indices** in the deque. This allows you to easily check if an element is still in the window.
- **One Pass**: The algorithm is `O(N)` because each element enters and leaves the deque exactly once.
- **Space Efficiency**: The deque size never exceeds `k`.

## Common Pitfalls
- **Empty Check**: Forgetting `!deque.isEmpty()` before `peek` or `poll`.
- **Logic Error**: Removing from the front based on the *element value* instead of the *index*.
- **Off-by-one**: Incorrectly calculating the result array size `n - k + 1` or the window boundary `i >= k - 1`.

## Complexity
- **Time Complexity**: `O(N)`.
- **Space Complexity**: `O(k)` for the deque.

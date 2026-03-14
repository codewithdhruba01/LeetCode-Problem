# Revision Notes: Binary Search

## Core Concept
- **Divide and Conquer**: Binary search works by repeatedly dividing the sorted search interval in half.

## Algorithm Logic
1. Start with two pointers: `left` at the first index, `right` at the last index.
2. Loop condition: `while (left <= right)`. The `<=` is crucial because `left == right` means there's a single element left to check.
3. Calculate midpoint: `mid = left + (right - left) / 2`.
4. Check element at `mid`:
   - If it's the target, return `mid`.
   - If it's smaller, search the right half: `left = mid + 1`.
   - If it's larger, search the left half: `right = mid - 1`.
5. Return `-1` if the loop ends.

## Key Insights
- **Overflow Prevention**: Writing `mid = (left + right) / 2` can cause integer overflow if `left` and `right` are very large. `mid = left + (right - left) / 2` calculates the distance, halves it, and adds it to `left`, which is always safe.
- **Sorted Requirement**: Binary search *only* works on sorted arrays.

## Complexity
- **Time Complexity**: `O(log N)` — The search space is halved in every iteration.
- **Space Complexity**: `O(1)` — Iterative implementation requires constant extra space.

## Common Pitfalls
- **Infinite Loops**: Failing to add/subtract 1 (`left = mid` instead of `left = mid + 1`) can lead to infinite loops, especially when `left` and `right` are adjacent.
- **Loop Condition**: Using `while (left < right)` instead of `while (left <= right)` might miss the final element if the target is located there.

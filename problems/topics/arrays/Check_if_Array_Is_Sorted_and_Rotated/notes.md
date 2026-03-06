# Revision Notes: Check if Array Is Sorted and Rotated

## Core Concept
- **Circular Sorted Property**: If an array is sorted and then rotated, it remains "mostly" sorted. Specifically, there is at most **one** pair of adjacent elements where `nums[i] > nums[i+1]`.
- **The Wrap-Around**: To handle rotations, we must also check if the last element is less than or equal to the first element.

## Algorithm Logic
1. Iterate from `0` to `n-1`.
2. Compare `nums[i]` with `nums[(i + 1) % n]`.
3. Increment a `count` whenever `nums[i] > nums[next]`.
4. return `count <= 1`.

## Key Insights
- **Why `count <= 1`?**
  - `count == 0`: The entire array is non-decreasing AND the last element is $\le$ the first element. This happens for arrays like `[1, 1, 1]` or `[1, 2, 3]`.
  - `count == 1`: There is exactly one "pivot" point where the rotation occurred.
- **Handling Duplicates**: The logic holds even with duplicates because we use the `>` operator (only counting strictly decreasing points).

## Complexity
- **Time Complexity**: `O(N)` — Single pass through the array.
- **Space Complexity**: `O(1)` — No extra space used regardless of input size.

## Common Pitfalls
- **Ignoring the Wrap-Around**: Only checking `nums[i] > nums[i+1]` for `i < n-1` will fail for cases like `[2, 1, 3, 4]`, which matches the condition but isn't a rotation of a sorted array (it would need the last element `4` to be $\le$ the first element `2`).

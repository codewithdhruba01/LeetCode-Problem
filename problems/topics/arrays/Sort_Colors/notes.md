# Revision Notes: Sort Colors

## Core Concept
- **Dutch National Flag Problem**: Created by Edsger Dijkstra. It's a classic problem for partitioning an array into three sections based on a pivot (or values).
- **Three-Pointer Technique**:
    - `low`: Bound for `0`s.
    - `high`: Bound for `2`s.
    - `mid`: Current element.

## Algorithm Logic
1. Initialize `low = 0`, `mid = 0`, `high = n - 1`.
2. While `mid <= high`:
    - `nums[mid] == 0`: Swap with `low`, increment `low` and `mid`.
    - `nums[mid] == 1`: Increment `mid`.
    - `nums[mid] == 2`: Swap with `high`, decrement `high`.

## Key Insights
- **Why `mid` doesn't increment on `2`?**
    - When we swap `mid` with `high`, we don't know what was originally at `high`. It could be a `0`, `1`, or `2`. We need to check the newly swapped element at `mid` in the next iteration.
- **Why `mid` increments on `0`?**
    - Since `mid` always stays ahead of or equal to `low`, and all elements before `mid` have already been processed, we know that the element swapped from `low` to `mid` is always a `1` (or itself a `0` if `low == mid`).

## Common Pitfalls
- **While Condition**: Using `mid < high` instead of `mid <= high`.
- **Incrementing mid on 2**: Forgetting that the element swapped from the end needs to be inspected.

## Complexity
- **Time Complexity**: `O(N)` — Single pass.
- **Space Complexity**: `O(1)` — In-place swap.

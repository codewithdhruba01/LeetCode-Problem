# Revision Notes: Spiral Matrix

## Core Concept
- **Boundary Management**: The key is maintaining four pointers (`top`, `bottom`, `left`, `right`) that represent the current bounds of the spiral.
- **Traversal Order**: Always follow the sequence: 
  1. Left-to-Right
  2. Top-to-Bottom
  3. Right-to-Left (checked with `if`)
  4. Bottom-to-Top (checked with `if`)

## Algorithm Logic
1. Start `top` and `left` at `0`, `bottom` at `m-1`, `right` at `n-1`.
2. Use a `while` loop that runs as long as the boundaries don't cross.
3. Shrink the boundary after each traversal direction is completed.
4. **Crucial**: After moving `top` down and `right` in, you must check `top <= bottom` and `left <= right` before the reverse traversals to prevent re-processing elements in a single row/column matrix.

## Key Insights
- **Non-square Matrices**: The inner checks (`if (top <= bottom)`) are what make the algorithm robust for rectangular matrices.
- **Space Efficiency**: The problem can be solved in-place if the output requirement is ignored.

## Complexity
- **Time Complexity**: `O(M * N)` — Every element is visited exactly once.
- **Space Complexity**: `O(1)` — No extra space other than the result list.

## Common Pitfalls
- **Missing the `if` checks**: Forgetting the checks before Right-to-Left and Bottom-to-Top results in duplicate elements for matrices like `[[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]`.
- **Off-by-one errors**: Ensure indices always include the boundaries (`i <= right`, `i >= left`, etc.).

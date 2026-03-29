# Revision Notes: Subsets

## Core Concept
- **Power Set**: A set containing all possible subsets, including the empty set and the set itself.
- **Backtracking Pattern**: 
  1. Add current state to result.
  2. Loop through candidates.
  3. Choose candidate $\to$ Recurse $\to$ Un-choose (Remove).

## Key Implementation Details
- **List Copy**: `result.add(new ArrayList<>(temp))` is critical. If you add `temp` directly, all entries in `result` will point to the same empty list after backtracking finishes.
- **Start Index**: The `start` parameter ensures that we only consider elements to the right of the current one, preventing duplicate subsets like `[1, 2]` and `[2, 1]`.

## Why Backtracking?
- It systematically explores the branching space. For an array of size $N$, there are $2^N$ subsets.
- Backtracking allows us to build these subsets without redundant work or duplicates.

## Alternative: Bit Manipulation
- Since there are $2^N$ subsets, we can iterate from `0` to `2^N - 1`.
- For each number `i`, if the $j$-th bit is set, include `nums[j]` in the subset.
- This is very efficient for $N \le 31$.

## Complexity
- **Time**: $O(N \cdot 2^N)$ - $2^N$ subsets, each taking $O(N)$ for copying.
- **Space**: $O(N)$ for the recursion stack and temporary list.

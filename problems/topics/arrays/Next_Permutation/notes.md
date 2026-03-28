# Revision Notes: Next Permutation

## Core Concept
- **Lexicographical Order**: To get the *next* larger permutation, we must change the rightmost possible element that can be increased.
- **Structural Invariant**: The sequence to the right of the first "decreasing" element (peak index `i`) is always in descending order.

## The Algorithm (4-Steps)
1. **Find the Breach (`i`)**: Find the first $nums[i] < nums[i+1]$ from the right.
2. **Find the Successor (`j`)**: Find the first $nums[j] > nums[i]$ from the right.
3. **Swap**: `swap(nums[i], nums[j])`.
4. **Reverse**: Reverse everything to the right of `i`.

## Why Reverse?
- After swapping `nums[i]` and `nums[j]`, the suffix is still in descending order.
- To make the entire number as small as possible (lexicographical next), we need that suffix to be in ascending order.
- Reversing a descending sequence is an $O(k)$ way to sort it into ascending order.

## Edge Case: Sorted Descending
- If no `i` is found (entire array is descending), `i` remains `-1`.
- Step 2 is skipped.
- Step 4 reverses the whole array, turning $[3, 2, 1]$ into $[1, 2, 3]$, which is the correct behavior for the "last permutation".

## Complexity
- **Time**: $O(N)$
- **Space**: $O(1)$ (In-place)

# Revision Notes: Single Element in a Sorted Array

## Core Concept
- **Pattern Break**: In a sorted array where every element appears twice except one, the first index `i` where `nums[i] != nums[i+1]` (for even `i`) indicates exactly where the single element resides.
- **Index Property**:
  - Before the single element: `pair(even_index, odd_index)` matches.
  - After the single element: `pair(odd_index, even_index)` matches.

## Binary Search Logic
1. Start `left = 0`, `right = nums.length - 1`.
2. Find `mid`.
3. Force `mid` to be the start of an even-odd pair: `if (mid % 2 == 1) mid--;`.
4. Check if `nums[mid] == nums[mid + 1]`:
   - **True**: The "broken" part is to the right. `left = mid + 2`.
   - **False**: The "broken" part is to the left (could be `mid` itself). `right = mid`.
5. Exit loop when `left == right`.

## Why this is tricky?
- It requires understanding that the constraints ($O(\log n)$) rule out simple XORing ($O(n)$) or Map-based counting ($O(n)$).
- Memory limit $O(1)$ rules out frequency maps.
- Binary search usually applies to finding values, but here it applies to finding the **index where a structural property breaks**.

## Complexity
- **Time**: $O(\log N)$ - Standard binary search.
- **Space**: $O(1)$ - No auxiliary data structures.

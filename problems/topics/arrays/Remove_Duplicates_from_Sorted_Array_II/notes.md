# Revision Notes: Remove Duplicates from Sorted Array II

## Core Concept
- **Generalization**: This is a generalization of the "Remove Duplicates" problem. Instead of allowing at most 1 occurrence, we allow at most `k` (in this case, `k=2`).
- **Lookback Strategy**: Instead of comparing `nums[i]` with `nums[i-1]`, we compare `nums[i]` with the element that was placed `k` positions ago in the output part of the array (`nums[index-k]`).

## Algorithm Logic
```java
int index = 2; // Allow at most 2
for (int i = 2; i < nums.length; i++) {
    if (nums[i] != nums[index - 2]) {
        nums[index] = nums[i];
        index++;
    }
}
```
- **Why `index - 2`?** Because the array is sorted, if `nums[i]` is the same as `nums[index-2]`, then `nums[index-1]` must also be the same. Thus, placing `nums[i]` at `index` would create three consecutive identical elements.

## Common Pitfalls
- **Base Case**: Handle arrays with length `< 2` correctly.
- **Index vs i**: Confusing the loop counter `i` with the insertion pointer `index`. Always compare against the inserted part (`index - 2`), not the source part.

## Complexity
- **Time Complexity**: `O(N)` — Single linear scan.
- **Space Complexity**: `O(1)` — In-place modification.

## Related Problems
- **Remove Duplicates from Sorted Array I**: (Compare with `index - 1`).
- **Remove Element**: Shifting elements based on a condition.

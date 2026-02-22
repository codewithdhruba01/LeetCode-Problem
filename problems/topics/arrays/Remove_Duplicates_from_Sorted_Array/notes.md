# Revision Notes: Remove Duplicates from Sorted Array

## Core Concept
- **In-place Modification**: The problem requires modifying the input array in-place. We cannot use extra space for a new array.
- **Two Pointers Technique**:
    - **Slow pointer (`i`)**: Points to the last confirmed unique element.
    - **Fast pointer (`j`)**: Scans through the rest of the array.
- **Sorted Property**: Since the array is sorted, all duplicates are adjacent. This makes the two-pointer approach very efficient.

## Algorithm Logic
```java
int i = 0;
for (int j = 1; j < nums.length; j++) {
    if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
    }
}
return i + 1;
```

## Common Pitfalls
- **Returning the length**: Remember to return `i + 1`, not just `i` (because `i` is an index).
- **Empty Array**: Always check for `nums.length == 0` to avoid errors.
- **Overwriting unique elements**: Be careful not to advance the slow pointer prematurely.

## Complexity
- **Time Complexity**: `O(N)` — Single pass through the array.
- **Space Complexity**: `O(1)` — No extra space used, modifications are done in-place.

## Related Problems
- **Remove Duplicates from Sorted Array II**: Each element can appear at most twice.
- **Move Zeroes**: Similar two-pointer shuffling logic.
- **Remove Element**: Removing all occurrences of a specific value in-place.

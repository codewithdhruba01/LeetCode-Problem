# Revision Notes: Move Zeroes

## Core Concept
-   **Two Pointers (Insert Index)**: Maintain an index `insertPos` for where the next non-zero element should go.
-   **Two Steps**:
    1.  Shift all non-zero elements to the left.
    2.  Fill the remaining slots with zeros.

## Algorithm Logic
```java
int insertPos = 0;
// Step 1: Shift non-zeros
for (int num : nums) {
    if (num != 0) {
        nums[insertPos++] = num;
    }
}
// Step 2: Fill zeros
while (insertPos < nums.length) {
    nums[insertPos++] = 0;
}
```

## Common Pitfalls
-   Trying to swap elements immediately. While possible, the two-pass approach (shift then fill) is often cleaner and easier to reason about, though a single-pass swap approach is also `O(n)`.
-   Forgetting to fill the rest of the array with zeros after moving the non-zero elements.

## Complexity
-   **Time**: `O(n)` - Iterate through array.
-   **Space**: `O(1)` - In-place modification.

## Key Points
-   Minimizes writes if the array has many zeros (swapping approach might do more writes in some cases, but shift-fill is standard).
-   Must maintain relative order of non-zero elements (stable).

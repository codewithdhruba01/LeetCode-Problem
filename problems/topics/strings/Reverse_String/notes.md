# Revision Notes: Reverse String

## Core Concept
-   **Two Pointers**: Swap elements from both ends moving inwards.
-   **In-Place**: Modify the original array without creating a new one.

## Algorithm Logic
```java
while (left < right) {
    swap(s[left], s[right]);
    left++;
    right--;
}
```

## Common Pitfalls
-   Using `left <= right` in the loop condition. While not incorrect, the equality case (middle element) doesn't need swapping, so strictly `<` is slightly more optimized.
-   Forgetting to declare a `temp` variable for swapping.

## Complexity
-   **Time**: `O(N)` - Linear scan (actually N/2 swaps).
-   **Space**: `O(1)` - Constant extra space.

## Alternative Approaches
-   **Recursion**: `reverse(start, end)`. Uses stack space `O(N)`, not `O(1)`.
-   **Stack**: Push all chars to stack, then pop. Uses `O(N)` space.
-   **Collections.reverse()**: If using `List<Character>`, but not applicable for primitive `char[]` directly.

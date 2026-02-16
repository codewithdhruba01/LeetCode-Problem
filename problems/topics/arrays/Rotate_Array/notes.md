# Revision Notes: Rotate Array

## Core Concept
-   **In-Place Modification**: The challenge is to do this without `O(N)` extra space.
-   **Reversal Algorithm**: The most elegant and optimal approach.
    1.  Reverse the **whole** array.
    2.  Reverse the **first parts** (0 to k-1).
    3.  Reverse the **second parts** (k to n-1).

## Algorithm Logic
```java
k = k % n; // Essential!
reverse(nums, 0, n - 1);
reverse(nums, 0, k - 1);
reverse(nums, k, n - 1);
```

## Common Pitfalls
-   **Forgetting Modulo**: If `k > nums.length`, the code will crash or give wrong results without `k = k % n`.
-   **Index Out of Bounds**: Be careful with indices in `reverse` function (`n-1`, `k-1`).
-   **Cyclic Replacements (Alternative)**: Another `O(1)` space approach involves cyclic jumps, but it's much harder to implement correctly (requires tracking count/GCD). Reversal is preferred for interviews.

## Complexity
-   **Time**: `O(N)`
-   **Space**: `O(1)`

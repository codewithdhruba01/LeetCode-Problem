# Revision Notes: Jump Game

## Core Concept
-   **Greedy Approach**: At every step, update the furthest possible index we can reach (`maxReach`).
-   **Unreachable Condition**: If at any point `i > maxReach`, it means there is a gap we cannot jump over.

## Algorithm Logic
```java
int maxReach = 0;
for (int i = 0; i < nums.length; i++) {
    if (i > maxReach) return false; // Cannot reach current index
    maxReach = Math.max(maxReach, i + nums[i]);
    if (maxReach >= nums.length - 1) return true; // Reached end
}
```

## Common Pitfalls
-   **Not checking `i > maxReach`**: If you only update `maxReach`, you might skip over zeros that actually block the path (like in `[3, 2, 1, 0, 4]`).
-   **Off-by-one errors**: The target is `nums.length - 1`.

## Complexity
-   **Time**: `O(N)` - Single pass.
-   **Space**: `O(1)` - One variable.

## Alternative Approaches
-   **Dynamic Programming**: Create a `boolean[] dp` where `dp[i]` represents if index `i` is reachable. `O(N^2)` time, so Greedy is much better.
-   **Backtracking**: Try every jump pattern. `O(2^N)`, very slow.

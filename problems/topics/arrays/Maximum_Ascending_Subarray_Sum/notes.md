# Revision Notes: Maximum Ascending Subarray Sum

## Core Concept
-   **Linear Scan**: Simply iterate and accumulate sum as long as the sequence is strictly increasing (`nums[i] > nums[i-1]`).
-   **Reset on Break**: When the condition fails, reset `currentSum` to `nums[i]` because a new ascending subarray must start from the current element.

## Algorithm Logic
```java
int currentSum = nums[0];
int maxSum = nums[0];
for (int i = 1; i < nums.length; i++) {
    if (nums[i] > nums[i-1]) {
        currentSum += nums[i];
    } else {
        currentSum = nums[i];
    }
    maxSum = Math.max(maxSum, currentSum);
}
```

## Common Pitfalls
-   **Initialization**: Initialize `currentSum` and `maxSum` with `nums[0]`. If initialized to 0, it might work for positive numbers (as per constraints), but `nums[0]` is safer and more logically correct as a subarray must contain at least one element.
-   **Updating Max**: Don't forget to update `maxSum` inside the loop, either at every step or just before resetting. Updating at every step handles cases where the maximum sum ends at the very last element.

## Complexity
-   **Time**: `O(N)`
-   **Space**: `O(1)`

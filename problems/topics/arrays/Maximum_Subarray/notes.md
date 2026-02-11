# Revision Notes: Maximum Subarray

## Core Concept
-   **Kadane's Algorithm** is the optimal approach for this problem.
-   **Key Logic**: If the sum of a subarray becomes negative, it's detrimental to continue adding to it. Start fresh from the current element.
    -   `currentSum = Math.max(nums[i], currentSum + nums[i])`
    -   `maxSum = Math.max(maxSum, currentSum)`

## Common Pitfalls
-   Initializing `maxSum` to 0 instead of `Integer.MIN_VALUE` or `nums[0]`. This fails if the array contains only negative numbers (e.g., `[-1]`).
-   Forgetting to update `maxSum` *after* updating `currentSum`.

## Complexity
-   **Time**: `O(n)` - Single pass.
-   **Space**: `O(1)` - Only two variables needed.

## Alternative Approaches
-   **Brute Force**: Check all subarrays. `O(n^2)` or `O(n^3)`. Too slow for large inputs.
-   **Divide and Conquer**: Recursive approach. `O(n log n)`.
    -   Split array into two halves.
    -   Max subarray is either in the left half, right half, or crossing the midpoint.
    -   More complex to implement than Kadane's, but good for understanding D&C.

## Related Problems
-   Maximum Product Subarray
-   Best Time to Buy and Sell Stock

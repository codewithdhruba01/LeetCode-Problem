# Revision Notes: Maximum Product Subarray

## Core Concept
- **Dynamic Programming**: We solve this by keeping track of optimal subproblems ending at the current index.
- **Why track Min product?**: Unlike the Maximum Sum Subarray (Kadane's), where we only care about large numbers, here a very small (large negative) product can become the new maximum if multiplied by another negative number later.

## Key Logic
1. Initialize `maxSoFar`, `minSoFar`, and `result` with `nums[0]`.
2. Iterate from the second element:
   - If current is **negative**, swap `maxSoFar` and `minSoFar`.
   - Update `maxSoFar = max(curr, maxSoFar * curr)`.
   - Update `minSoFar = min(curr, minSoFar * curr)`.
   - `result = max(result, maxSoFar)`.

## Common Pitfall
- **Zero handling**: Multiplying by zero resets the current product. The logic `Math.max(curr, maxSoFar * curr)` naturally handles this as it chooses `0` (curr) if the product was之前 smaller.
- **Integer Overflow**: Although guaranteed to fit in 32-bit, keep an eye on product scaling for other variants.

## Complexity
- **Time**: $O(N)$ - Single pass.
- **Space**: $O(1)$ - Constant space variables.

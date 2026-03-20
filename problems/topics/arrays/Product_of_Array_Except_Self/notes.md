# Revision Notes: Product of Array Except Self

## Core Concept
- The product of an array except self at index `i` is simply the product of all elements *before* `i` multiplied by the product of all elements *after* `i`.
- `result[i] = (prefix product of i) * (suffix product of i)`.

## Algorithm Logic (Space Optimized)
1. **First Pass (Left to Right)**: Use the `result` array to store only prefix products.
   - Initialize `result[0] = 1`.
   - Iterate `i` from `1` to `len - 1`: `result[i] = result[i-1] * nums[i-1]`.
2. **Second Pass (Right to Left)**: Trailing suffix calculation.
   - Initialize a variable `suffix = 1`.
   - Iterate `i` backward from `len - 1` to `0`:
     - Calculate final answer: `result[i] = result[i] * suffix`.
     - Update suffix for the next step: `suffix *= nums[i]`.

## Key Insights
- **Why avoid division?**: If the array contains a `0`, division by zero is illegal. If you try to handle `0` as an edge case (e.g., counting zeros), it gets messy if there are multiple zeros, and the problem explicitly outlaws division anyway. The prefix/suffix approach naturally handles zeros correctly without any special `if/else` logic.
- **Space Optimization**: Utilizing the *return array* `result` for intermediate operations (storing prefix products) is a very common LeetCode trick when solving follow-ups asking for "O(1) extra space where the output array doesn't count".

## Complexity
- **Time Complexity**: $O(N)$ because the algorithm completes in exactly two non-nested passes over the array.
- **Space Complexity**: $O(1)$ auxiliary space because we only use one extra `int suffix` variable.

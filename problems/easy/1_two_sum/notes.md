# Notes for Problem 1: Two Sum

## Key Learnings

- Hash maps provide O(1) lookup time, making them perfect for finding complements
- Single pass solution is more efficient than brute force O(n²)
- Store indices, not values, since we need to return positions

## Mistakes Made

- Initially tried nested loops (brute force) - too slow for large inputs
- Forgot to handle case where same number appears twice (like [3,3] target 6)

## Alternative Approaches

1. **Brute Force**: Two nested loops - O(n²) time, O(1) space
2. **Two Pointers**: Sort array first, then use two pointers - O(n log n) time due to sorting
3. **Hash Map**: Current approach - O(n) time, O(n) space

## Related Problems

- 15. 3Sum
- 18. 4Sum
- 167. Two Sum II (sorted array)
- 170. Two Sum III (add/remove operations)
- 653. Two Sum IV (BST)

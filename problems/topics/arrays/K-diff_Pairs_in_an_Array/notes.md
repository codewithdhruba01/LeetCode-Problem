# Revision Notes: K-diff Pairs in an Array

## Core Concept
- **Uniqueness**: The problem specifically asks for *unique* pairs. Using keys of a HashMap automatically handles the uniqueness of the starting element.
- **K=0 Case**: When `k=0`, a pair consists of the same number twice. This is only possible if that number appears at least twice in the input.

## Algorithm Logic
1. Build a frequency map of all numbers.
2. Iterate over the keys of the map.
3. For each `key`:
   - If `k > 0`, check if `key + k` exists. We only check `+k` (not `-k`) to ensure each pair is counted exactly once.
   - If `k = 0`, check if `map.get(key) > 1`.

## Key Insights
- **O(N) vs O(N log N)**: Sorting would lead to an `O(N log N)` approach with two pointers. The HashMap approach is `O(N)` but uses extra space.
- **Why `num + k`?**: By only checking for the higher element of the pair, we guarantee that each unique pair `(a, b)` where `b = a + k` is counted exactly when we process `a`.

## Complexity
- **Time Complexity**: `O(N)` — Linear scan to build the map and linear scan of keys.
- **Space Complexity**: `O(N)` — In the worst case, all elements are unique.

## Common Pitfalls
- **Double Counting**: Checking both `num + k` and `num - k` would double the count for `k > 0`.
- **k=0 ignored**: Forgetting that `k=0` requires frequency checking rather than existence checking.

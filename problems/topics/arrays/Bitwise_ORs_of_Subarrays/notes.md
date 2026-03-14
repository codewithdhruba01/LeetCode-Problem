# Revision Notes: Bitwise ORs of Subarrays

## Core Concept
- **Monotonic Property of Bitwise OR**: `A | B` always has at least as many "1" bits as `A` or `B` individually. The number of set bits can only increase.
- **Bounding Unique Values**: Because an integer has at most 32 bits (in this problem bounds $\le 10^9$, it's exactly 30 bits), starting from any `A`, doing `A | B | C...` can change the value *at most 30 times*.
- Thus, the number of unique OR values of subarrays ending exactly at index `i` is bounded by 30.

## Algorithm Logic
1. `result`: A HashSet collecting *all* globally unique OR answers.
2. `prev`: A HashSet containing all unique OR answers of subarrays that ended at the previous index `i-1`.
3. Loop through `list` elements `num`:
   - Initialize `curr` HashSet.
   - Subarray of length 1: add `num` to `curr`.
   - Extend existing subarrays: for every `val` in `prev`, add `val | num` to `curr`.
   - Update state: add everything in `curr` to `result`, then `prev = curr`.
4. Return `result.size()`.

## Key Insights
- **Why DP?**: "Values ending at `i-1`" relates to "Values ending at `i`". This is the classic dynamic programming overlapping subproblem property.
- **Why Set?**: Using HashSets naturally deduplicates numbers, keeping `prev` to its theoretical max size of ~30. If we used an ArrayList, the inner loop would explode to $O(N)$ making it $O(N^2)$ overall.

## Complexity
- **Time Complexity**: `O(30 * N)` which simplifies to `O(N)`. The inner loop over `prev` runs at most 30 times.
- **Space Complexity**: `O(N)` bounds. The `result` set can hold at worst $30 \cdot N$ elements. `prev` and `curr` hold at most 30 elements at any given time, which is `O(1)`.

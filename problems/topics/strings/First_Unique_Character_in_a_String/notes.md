# Revision Notes: First Unique Character in a String

## Core Concept
- **Frequency Counting**: The problem boils down to knowing how many times each character appears.
- **Ordered Traversal**: To find the *first* unique character, we must traverse the string in its original order during the second pass.

## Algorithm Logic
1. `int[] freq = new int[26]`
2. Loop 1: `freq[c - 'a']++` for all `c` in `s`.
3. Loop 2: If `freq[c - 'a'] == 1`, return index.

## Optimized Thinking
- **Why an array?**: An array of size 26 is much faster than a `HashMap` for this specific case because the character set is limited and fixed.
- **Space-Time Tradeoff**: Using `O(1)` space (fixed array) to achieve `O(N)` time.

## Common Pitfalls
- **Index vs Character**: Forgetting to return the index `i` and instead returning the character or frequency.
- **Case Sensitivity**: The problem specifies lowercase English letters; always subtract `'a'` to map to `0-25`.
- **No Unique Found**: Always ensure the default return is `-1`.

## Complexity
- **Time Complexity**: `O(N)` where `N` is string length (2 passes).
- **Space Complexity**: `O(1)` as the array size is constant (26).

# Revision Notes: Length of Last Word

## Core Concept
- **Efficiency**: Instead of splitting the string into an array (which uses `O(N)` space), traverse from the end to achieve `O(1)` extra space.
- **Handling Spaces**: The main challenge is ignoring multiple trailing spaces and stopping at the first internal space after the last word.

## Algorithm Logic
1. Initialize `i = s.length() - 1`.
2. `while` loop to decrement `i` while `s.charAt(i)` is a space.
3. `while` loop to decrement `i` and increment `length` while `s.charAt(i)` is NOT a space.
4. Return `length`.

## Key Insights
- **Reverse Traversal**: Always think of reverse traversal when asked about "last" elements.
- **`trim()` and `split()`**: While easier to write (`s.trim().split(" ")`), they are less efficient in terms of memory because they create new string objects and arrays.

## Complexity
- **Time Complexity**: `O(N)` where `N` is string length.
- **Space Complexity**: `O(1)` — only primitive variables used.

## Common Pitfalls
- **Index Out of Bounds**: Forgetting to check `i >= 0` in both `while` loops.
- **Trailing Spaces**: Returning `0` because you hit a trailing space first.

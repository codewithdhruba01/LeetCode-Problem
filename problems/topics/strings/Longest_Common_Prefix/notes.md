# Revision Notes: Longest Common Prefix

## Core Concept
-   **Horizontal Scanning**: Compare prefix with each string one by one.
-   **Key Logic**:
    -   `prefix = strs[0]`
    -   `while (strs[i].indexOf(prefix) != 0)` reduce `prefix`.
    -   `indexOf` returns `0` if the string starts with `prefix`.

## Common Pitfalls
-   Not handling the edge case where `strs` is empty or null.
-   Not checking if `prefix` becomes empty inside the loop (optimization).
-   Confusing `indexOf(prefix) != 0` with `contains`. We need it to be a **prefix** (start at index 0).

## Complexity
-   **Time**: `O(S)` - where S is sum of all characters.
-   **Space**: `O(1)` - Modify prefix in place (or reassign).

## Alternative Approaches
-   **Vertical Scanning**: Compare characters column by column. Useful if strings are very long but prefix is short.
-   **Divide and Conquer**: Split logic similar to Merge Sort.
-   **Binary Search**: Search on the length of the prefix.
-   **Trie**: Insert all strings into a Trie.

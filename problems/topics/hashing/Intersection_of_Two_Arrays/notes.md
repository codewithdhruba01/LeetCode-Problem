# Revision Notes: Intersection of Two Arrays

## Core Concept
- **Set Uniqueness**: The problem requires unique elements in the result. Using a `HashSet` is the most efficient way to ensure uniqueness and fast lookups.
- **Intersection Logic**: Element $x \in Intersection(A, B)$ if and only if $x \in A$ and $x \in B$.

## Key Logic
1. Insert all elements of $nums1$ into `Set1`.
2. Iterate through $nums2$ and check if `Set1` contains the current element.
3. If yes, add it to `ResultSet`.
4. Convert `ResultSet` to `int[]`.

## Alternative Approaches
- **Sorting + Two Pointers**: Sort both arrays ($O(N \log N + M \log M)$). Use two pointers to find common elements. Useful if space is restricted.
- **BitSet Optimization**: Since Constraints mention $0 \le nums[i] \le 1000$, a `boolean[1001]` or a `BitSet` could be used instead of a `HashSet` to save memory and potentially speed up processing for this specific range.

## Complexity
- **Time**: $O(N + M)$ - Two linear passes.
- **Space**: $O(N + M)$ - To store the elements in sets.

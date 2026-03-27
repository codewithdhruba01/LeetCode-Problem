# Revision Notes: Largest Number

## Core Concept
- **Greedy Strategy**: To form the largest overall number, for any two numbers $A$ and $B$, $A$ should precede $B$ if $concatenation(A, B) > concatenation(B, A)$.
- **Sorting Criterion**: The relation "A comes before B if $A+B > B+A$" is transitive, which allows us to use it as a sorting comparator.

## Implementation Details
1. **String Conversion**: Numbers must be converted to strings to easily handle concatenation and comparison.
2. **Comparator**: Use `(b + a).compareTo(a + b)` for descending order based on the concatenation result.
3. **Zero Case**: If the sorted array starts with "0", return "0" immediately. This handles cases like `[0, 0, 0]`.
4. **Efficiency**: Use `StringBuilder` for concatenating many strings in Java to avoid $O(N^2)$ string creation overhead.

## Key Insights
- **Why not regular string sort?**: "10" is lexicographically smaller than "2", but "102" is smaller than "210". Standard string sorting isn't enough; we must test the *concatenated* results.
- **Large Inputs**: Since the constraints allow 100 numbers and the result can be huge, string-based return is mandatory.

## Complexity
- **Time**: $O(N \log N \cdot K)$ where $N$ is number of elements and $K$ is average length of strings (for comparisons).
- **Space**: $O(N \cdot K)$ to store the array of strings and the final result.

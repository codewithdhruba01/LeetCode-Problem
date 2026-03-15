# Revision Notes: Toeplitz Matrix

## Core Concept
- **Diagonal Property Translation**: A matrix is Toeplitz if all elements on the same diagonal are identical. An easier way to program this statement is: "Every element must equal its top-left neighbor".

## Algorithm Logic
1. Iterate over the matrix rows starting from index `1` (the second row).
2. Inside, iterate over the matrix columns starting from index `1` (the second column).
3. Check `if (matrix[i][j] != matrix[i-1][j-1])`. If true, return `false`.
4. If loops finish, return `true`.

## Key Insights
- By avoiding the first row (`i=0`) and first column (`j=0`), we inherently avoid `IndexOutOfBoundsException` because `i-1` and `j-1` will never go below `0`.
- This simple neighbor check avoids the complex index math required to traverse a matrix purely diagonally.

## Complexity
- **Time Complexity**: `O(M * N)` to visit all valid pairs. This is optimal since we must read the matrix to verify it.
- **Space Complexity**: `O(1)` as we do it in-place without auxiliary data structures.

## Follow up Questions
- **Limited Memory (one row at a time)**: If we can only load one row into memory, we really just need the *previous* row. Instead of comparing `matrix[i][j]` and `matrix[i-1][j-1]`, we compare `currentRow[j]` to `previousRow[j-1]`. Space becomes $O(N)$.
- **Partial Row loading**: If we can't even load a full row, we could split the matrix into smaller overlapping vertical chunks or use a sliding window approach, passing only the needed boundary values to the next chunk processing step.

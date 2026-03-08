# Revision Notes: Set Matrix Zeroes

## Core Concept
- **Space Optimization**: The challenge is to avoid extra space. Instead of using separate boolean arrays for rows and columns, we use the matrix's own first row and column.
- **Marker Strategy**: `matrix[i][0] = 0` means row `i` should be zero. `matrix[0][j] = 0` means column `j` should be zero.

## Algorithm Logic
1. Scan the first row and first column separately to see if they should be zeroed (save these in two booleans).
2. Scan the rest of the matrix (`1,1` to `m,n`). If `cell[i][j] == 0`, mark `matrix[i][0] = 0` and `matrix[0][j] = 0`.
3. Fill zeros for the inner matrix based on these markers.
4. Finally, update the first row and column based on the saved booleans.

## Key Insights
- **In-Place**: Achieving $O(1)$ space requires "stealing" space from the input itself.
- **Order of Operations**: It's critical to check the first row/column *before* using them as markers, and update them *after* updating the rest of the matrix.

## Complexity
- **Time Complexity**: `O(M * N)` — Two passes over the matrix.
- **Space Complexity**: `O(1)` — No extra data structures used.

## Common Pitfalls
- **Overwriting Markers**: If you zero out the first row too early, you lose the markers for the columns.
- **Edge Cases**: Empty matrices or 1x1 matrices.

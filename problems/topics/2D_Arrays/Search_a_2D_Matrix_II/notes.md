# Revision Notes: Search a 2D Matrix II

## Core Concept
- **Binary Search Tree Property**: Starting from the top-right (or bottom-left) corner cleverly treats the matrix like a Binary Search Tree (BST). 
  - From top-right: Left child is smaller, Bottom child is larger.

## Algorithm Logic
1. Start `r = 0` (top row), `c = cols - 1` (rightmost column).
2. Loop condition: `while (r < rows && c >= 0)`. We stop when we fall off the bottom or the left edge of the matrix.
3. Compare `matrix[r][c]` to `target`:
   - `==`: Return `true`.
   - `>`: Target must be smaller, so we must go left (`c--`). We can discard the entire current column because everything below is even larger.
   - `<`: Target must be larger, so we must go down (`r++`). We can discard the entire current row because everything to the left is even smaller.
4. Return `false` if the loop ends.

## Key Insights
- **Why Top-Right?**: At the top-left `[0][0]`, going right or down both increase the value. There's no definitive way to rule out a row or column if the target is larger. At the top-right `[0][n-1]`, going left decreases, going down increases. This allows us to definitively eliminate a row or column at each step.
- **Bounds Checking**: The loop conditions naturally prevent `ArrayIndexOutOfBoundsException`s.

## Complexity
- **Time Complexity**: $O(m + n)$. The worst-case path goes all the way left and all the way down, taking $n$ steps left and $m$ steps down.
- **Space Complexity**: $O(1)$. No extra arrays or data structures are needed.

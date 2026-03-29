# Revision Notes: Pascal's Triangle

## Core Concept
- **Triangle Structure**: The $i$-th row has $i+1$ elements (0-indexed).
- **Additive Rule**: Each interior element is the sum of the two elements directly above it.
- **Base Case**: The "edges" of the triangle ($j=0$ or $j=row\_index$) are always $1$.

## Implementation Key Points
1. Use a nested loop: Outer loop for rows, inner loop for elements in each row.
2. Boundary check: Use `if (j == 0 || j == i)` to handle the $1$s at the edges.
3. Accessing previous row: `result.get(i - 1)` gives the previously constructed row.

## Why in Recursion Folder?
- While the most efficient solution is iterative ($O(N^2)$), this problem can also be solved recursively by viewing each row as a function of the previous row: `getRow(n) = f(getRow(n-1))`.
- This is a classic example of **Top-Down (Recursive)** vs **Bottom-Up (Iterative)** Dynamic Programming.

## Complexity
- **Time**: $O(N^2)$ where $N$ is `numRows`. We fill roughly $N^2/2$ cells.
- **Space**: $O(N^2)$ for storing the output.

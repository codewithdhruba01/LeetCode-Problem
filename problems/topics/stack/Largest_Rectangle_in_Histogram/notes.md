# Revision Notes: Largest Rectangle in Histogram

## Core Concept
- **The Observation**: A rectangle's height is determined by the **shortest bar** it contains. 
- **The Strategy**: For each bar $i$, find the largest rectangle where $heights[i]$ is the minimum height. This means finding the first smaller bar to its **left** and **right**.

## Monotonic Stack Algorithm
1. Store indices in a stack such that heights correspond to indices in **non-decreasing** order.
2. When current height $h < heights[stack.top()]$:
   - We've found the right boundary for the bar at the top of the stack.
   - Pop the top (height $H$).
   - The new top of the stack is the left boundary.
   - $Area = H \times (current\_index - stack\_top - 1)$.
3. **Pro-tip**: Use a loop that goes to $n$ and treats $heights[n]$ as $0$. This ensures all elements are popped and processed at the end.

## Complexity
- **Time**: $O(N)$ - Single pass, each index pushed/popped once.
- **Space**: $O(N)$ - In the worst case (increasing heights), all indices are stored in the stack.

## Common Pitfalls
- **Indices vs Heights**: Always store **indices** in the stack, not heights. This allows calculating the width.
- **Empty Stack**: Handle the case where the stack is empty after popping (width = current index).
- **Infinite Loop**: Forgetting to push the current index after the `while` loop pops elements.

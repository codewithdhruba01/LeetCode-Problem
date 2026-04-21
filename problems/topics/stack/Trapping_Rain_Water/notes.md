# Revision Notes: Trapping Rain Water

## Core Concept: Boundary Constraints

Water trapped at any index `i` is determined by the shorter of its two tallest neighbors (one on the left, one on the right). 
**Formula**: `Water[i] = max(0, min(maxLeft[i], maxRight[i]) - height[i])`

---

## ⚡ 1. The Two-Pointer Shortcut (Memory: $O(1)$)

This is the most impressive solution for interviews.

- **Principle**: We don't need to know the *exact* `maxRight` if we know that there is *some* bar to the right taller than our current `maxLeft`.
- **Logic**:
  - Keep `l` and `r` pointers.
  - If `height[l] < height[r]`, we move `l` and update based on `leftMax`.
  - If `height[r] <= height[l]`, we move `r` and update based on `rightMax`.
- **Why?**: Because if `height[l]` is smaller than `height[r]`, `height[r]` serves as a guaranteed "right wall" that is at least as high as `leftMax`.

---

## 🏗️ 2. The Monotonic Stack Approach (Memory: $O(N)$)

Ideal if you are specifically looking for a **Stack** application.

- **Type**: Monotonic **Decreasing** Stack.
- **Filling Pattern**: Instead of calculating water bar-by-bar (vertical), it calculates it layer-by-layer (horizontal).
- **Triggers**: When the current bar is *taller* than the stack top, it "traps" a pool of water.
- **Formula**: `width = i - stack.peek() - 1`, `height = min(currentH, boundaryH) - bottomH`.

---

## 🔑 Key Takeaways for Interviews

- **Three Solutions**: 
  1. Brute Force ($O(N^2)$)
  2. Dynamic Programming ($O(N)$ time, $O(N)$ space)
  3. Two Pointer / Stack ($O(N)$ time, $O(1)/O(N)$ space)
- **Edge Cases**: Empty array, sorted array (no water), reverse sorted array.

---

## 💡 Practical Tip
Visualize this problem as a **clash between two waves** coming from the left and right. The level of water is always "limited" by the smaller wave.

# Revision Notes: Reverse Linked List

## Core Concept: Pointer Swapping

Reversing a linked list is a fundamental problem that involves manipulating pointers. Instead of changing the values within the nodes, we change the direction of the `next` pointers.

---

## ⚡ Iterative Strategy (Recommended)

The iterative solution is the most space-efficient and common approach.

### The Three-Pointer Relay
- **`prev`**: Tracks the node processed in the previous step (starts as `null`).
- **`curr`**: The current node being processed (starts as `head`).
- **`next`**: A placeholder to store the remainder of the original list during the swap.

### Step-by-Step Logic
1.  **Save the Future**: Store the next node: `next = curr.next`.
2.  **Flip the Link**: Point the current node backward: `curr.next = prev`.
3.  **Advance**: Shift everything one step forward for the next iteration:
    - `prev = curr`
    - `curr = next`

---

## 🔁 Recursive Strategy

A more elegant but less space-efficient approach (due to the call stack).

### The "Reverse from the Tail" Principle
- Recursively call `reverseList` until we reach the last node.
- As the recursion unwinds, point each successor node back to the current node: `head.next.next = head`.
- Break the old link by setting `head.next = null`.

---

## 🔑 Key Takeaways for Interviews

- **Sentinel Value**: The new head is `prev`, not `curr`, because `curr` will be `null` at the end of the loop.
- **Edge Cases**: Always check for `head == null` or a single-node list (`head.next == null`). The iterative loop handles these naturally.
- **Complexity**: $O(N)$ time, $O(1)$ space (iterative).

---

## 💡 Practical Tip
When solving this, visualize it as **unplugging** a cord from one node and **plugging** it into the node behind it.

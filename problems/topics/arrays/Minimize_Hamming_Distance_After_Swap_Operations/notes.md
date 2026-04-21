# Revision Notes: Minimize Hamming Distance After Swap Operations

## Core Concept: Indices as Nodes

This problem transforms an array manipulation task into a **Graph** problem. The key is to realize that "allowed swaps" are like edges in a graph.

---

## ⚡ The DSU Insight

- **Transitive Property**: If you can swap index `A` with `B`, and `B` with `C`, you can effectively move the element at `A` to `C`.
- **Components**: All indices in a connected component can have their elements shuffled into **any order**.
- **The Ideal Outcome**: Within each component, we want to match as many elements as possible from the `source` set to the `target` set.

---

## 🛠️ Implementation Steps

1.  **Group Indices**: Use DSU to find connected components of indices based on `allowedSwaps`.
2.  **Inventory Source**: For each component, create a "store" (Frequency Map) of all values present in `source` at those indices.
3.  **Check Target**: For each index `i`:
    - Find which component index `i` belongs to.
    - Check the "store" for that component to see if it contains `target[i]`.
    - If yes: Match found! (Decremented frequency).
    - If no: Mismatch! (Increment Hamming Distance).

---

## 🔑 Key Takeaways for Interviews

- **Hamming Distance**: Simply the count of mismatches.
- **DSU Complexity**: Almost linear $O(N \alpha N)$, making it very efficient for $10^5$ constraints.
- **Why not sorting?**: Sorting elements in components also works but is $O(N \log N)$ and might be slightly slower/more complex to implement than a frequency map approach. Frequency maps (HashMaps) give $O(N)$ average time.

---

## 💡 Practical Tip
When you see "swappable elements" or "rearrangeable groups", think **DSU** or **BFS/DFS components**. The specific positions don't matter inside a component, only the **count of values** available.
